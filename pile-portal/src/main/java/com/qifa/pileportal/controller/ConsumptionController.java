package com.qifa.pileportal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.entity.Consumption;
import com.qifa.pileportal.service.ConsumptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 消费记录表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "ConsumptionController",description = "消费记录相关处理")
@RequestMapping("/consumption")
public class ConsumptionController {
    @Autowired
    private ConsumptionService consumptionService;

    @ApiOperation("根据id获取消费记录")
    @GetMapping("/getById/{id}")
    public CommonResult getConsumptionById(@PathVariable Integer id){
        QueryWrapper<Consumption> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        List<Consumption> list = consumptionService.list(queryWrapper);
        return CommonResult.success(list);
    }
}

