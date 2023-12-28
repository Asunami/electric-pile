package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.WarnConditionDTO;
import com.qifa.pileadmin.entity.Warn;
import com.qifa.pileadmin.service.WarnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 告警记录表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "WarnController",description = "告警信息处理相关")
@RequestMapping("/warn")
public class WarnController {
    @Autowired
    private WarnService warnService;

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody WarnConditionDTO warnConditionDTO){
        Page page = warnService.pageAll(warnConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = warnService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = warnService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("编辑")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Warn warn){
        boolean result =  warnService.saveOrUpdate(warn);
        return CommonResult.success(result);
    }
}

