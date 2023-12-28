package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.OrderConditionDTO;
import com.qifa.pileadmin.entity.Order;
import com.qifa.pileadmin.service.OrderService;
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
 * @since 2023-05-07
 */
@RestController
@Api(tags = "OrderItemController",description = "订单管理相关操作")
@RequestMapping("/order")
public class OrderItemController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody OrderConditionDTO orderConditionDTO){
        Page<Order> page = orderService.pageAll(orderConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }


    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = orderService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = orderService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("编辑")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Order order){
        boolean result = orderService.saveOrUpdate(order);
        return CommonResult.success(result);
    }


}

