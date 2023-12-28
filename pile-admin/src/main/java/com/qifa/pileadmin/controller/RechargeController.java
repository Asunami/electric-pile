package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.RechargeConditionDTO;
import com.qifa.pileadmin.entity.Recharge;
import com.qifa.pileadmin.service.RechargeService;
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
 * @since 2023-05-07
 */
@RestController
@Api(value = "RechargeController",description = "后台管理充值记录相关")
@RequestMapping("/recharge")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody RechargeConditionDTO rechargeConditionDTO){
        Page page = rechargeService.pageAll(rechargeConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = rechargeService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = rechargeService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("增加或编辑")
    @PostMapping("/addOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody Recharge entity){
        boolean result =  rechargeService.saveOrUpdate(entity);
        return CommonResult.success(result);
    }

}

