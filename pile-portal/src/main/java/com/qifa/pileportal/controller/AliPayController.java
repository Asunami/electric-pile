package com.qifa.pileportal.controller;

import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.config.AliPayConfig;
import com.qifa.pileportal.dao.RechargeMapper;
import com.qifa.pileportal.dao.UserMapper;
import com.qifa.pileportal.entity.AliPay;
import com.qifa.pileportal.entity.Recharge;
import com.qifa.pileportal.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@Api(tags = "AliPayController", description = "支付宝沙箱支付")
@RequestMapping("/alipay")
public class AliPayController {

    @Resource
    private AliPayConfig aliPayConfig;

    @Resource
    private RechargeMapper rechargeMapper;

    @Resource
    private UserMapper userMapper;

    @ApiOperation("支付宝沙箱请求接口")
    @GetMapping("pay")
    public void pay(AliPay aliPay, HttpServletResponse httpResponse) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(
                aliPayConfig.getGatewayUrl(),
                aliPayConfig.getAppId(),
                aliPayConfig.getAppPrivateKey(),
                aliPayConfig.getFormat(),
                aliPayConfig.getCharset(),
                aliPayConfig.getAlipayPublicKey(),
                aliPayConfig.getSign());

        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setNotifyUrl(aliPayConfig.getNotifyUrl());
        aliPayRequest.setReturnUrl(aliPayConfig.getReturnUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.set("out_trade_no", aliPay.getTradeNo().toString());  // 我们自己生成的订单编号
        bizContent.set("total_amount", aliPay.getTotalAmount()); // 订单的总金额
        bizContent.set("subject", aliPay.getSubject());   // 支付的名称
        bizContent.set("product_code", "FAST_INSTANT_TRADE_PAY");  // 固定配置
        aliPayRequest.setBizContent(bizContent.toString());

        String result = null;
        try {
            result = alipayClient.pageExecute(aliPayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + aliPayConfig.getCharset());
        httpResponse.getWriter().write(result);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @ApiOperation("支付宝沙箱异步回调订单接口")
    @PostMapping("/notify")
    public CommonResult payNotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
            }
            String outTradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String alipayTradeNo = params.get("trade_no");

            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, aliPayConfig.getAlipayPublicKey(), "UTF-8"); // 验证签名
            // 支付宝验签
            if (checkSignature) {
                // 验签通过
                System.out.println("验签通过");
                System.out.println("交易名称: " + params.get("subject"));
                System.out.println("交易状态: " + params.get("trade_status"));
                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                System.out.println("买家付款时间: " + params.get("gmt_payment"));
                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));


                Recharge recharge = rechargeMapper.selectById(outTradeNo);
                User user = userMapper.selectById(recharge.getUserId());

                recharge.setAlipayId(alipayTradeNo);
                recharge.setChargeTime(new Date());
                recharge.setStatus(2);
                rechargeMapper.updateById(recharge);
                user.setBalance(user.getBalance().add(recharge.getMoney()));
                userMapper.updateById(user);

            }
        }
        String result = "success";
        return CommonResult.success(result);
    }
}