package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.StationConditionDTO;
import com.qifa.pileadmin.entity.Station;
import com.qifa.pileadmin.service.StationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 电站表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "StationController",description = "电站管理相关")
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody StationConditionDTO StationConditionDTO){
        Page page = stationService.pageAll(StationConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = stationService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = stationService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("增加")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Station station){
        boolean result =  stationService.save(station);
        return CommonResult.success(result);
    }

    @ApiOperation("编辑，同时更新其下电桩状态为不可用")
    @PostMapping("/update")
    public CommonResult update(@RequestBody Station station){
        boolean result = stationService.updateWithPile(station);
        return CommonResult.success(result);
    }


}

