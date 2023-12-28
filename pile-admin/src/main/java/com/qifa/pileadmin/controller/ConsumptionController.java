package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.ConsumptionConditionDTO;
import com.qifa.pileadmin.entity.Consumption;
import com.qifa.pileadmin.service.ConsumptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 消费记录表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "ConsumptionController",description = "后台充值记录相关")
@RequestMapping("/consumption")
public class ConsumptionController {
    @Autowired
    private ConsumptionService consumptionService;

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody ConsumptionConditionDTO consumptionConditionDTO){
        Page page = consumptionService.pageAll(consumptionConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = consumptionService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = consumptionService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("增加或编辑")
    @PostMapping("/addOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody Consumption entity){
        boolean result =  consumptionService.saveOrUpdate(entity);
        return CommonResult.success(result);
    }

}

