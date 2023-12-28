package com.qifa.pileportal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.entity.Recharge;
import com.qifa.pileportal.service.RechargeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 充值记录表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "RechargeController",description = "充值记录相关")
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    RechargeService rechargeService;

    @ApiOperation("新增一条状态为未支付的充值记录")
    @PostMapping("/add")
    public CommonResult addRecharge(@RequestBody Recharge recharge) {
        boolean result = rechargeService.save(recharge);
        return CommonResult.success(result);
    }

    @ApiOperation("查询指定用户id的充值记录")
    @GetMapping("/getRecharge/{userId}")
    public CommonResult getById(@PathVariable Integer userId) {
        QueryWrapper<Recharge> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Recharge> list = rechargeService.list(queryWrapper);
        return CommonResult.success(list);
    }

    @ApiOperation("伪支付接口")
    @PostMapping("/pay")
    public CommonResult payRecharge(@RequestBody Recharge recharge) {
        boolean result = rechargeService.pay(recharge);
        return CommonResult.success(result);
    }
}

