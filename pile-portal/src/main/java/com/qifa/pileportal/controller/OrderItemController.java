package com.qifa.pileportal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.dto.OrderPayDTO;
import com.qifa.pileportal.entity.OrderItem;
import com.qifa.pileportal.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "OrderItmController",description = "订单处理")
@RequestMapping("/order")
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;

    @ApiOperation("更新预约记录状态，新增订单记录，新增消费记录，更新用户表余额")
    @PostMapping("/operation")
    public CommonResult operation(@RequestBody OrderPayDTO payDTO){
        boolean result = orderItemService.doManyThing(payDTO);
        return CommonResult.success(result);
    }

    @ApiOperation("根据用户id获取其订单记录")
    @GetMapping("/getById/{id}")
    public CommonResult getOrderById(@PathVariable Integer id){
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        List<OrderItem> list = orderItemService.list(queryWrapper);
        return CommonResult.success(list);
    }

    @ApiOperation("更改订单状态，新增消费记录，更新用户余额")
    @GetMapping("/alreadyPay/{id}")
    public CommonResult payOrderNow(@PathVariable Integer id){
        boolean result = orderItemService.payNow(id);
        return CommonResult.success(result);
    }

    @ApiOperation("根据用户id判断是否有未支付订单")
    @GetMapping("/checkIf/{id}")
    public CommonResult checkNoPay(@PathVariable Integer id){
        boolean result = orderItemService.checkIfPay(id);
        return CommonResult.success(result);
    }
}

