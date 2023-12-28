package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.PileConditionDTO;
import com.qifa.pileadmin.entity.Pile;
import com.qifa.pileadmin.service.PileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 充电桩表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "PileController",description = "充电桩管理相关")
@RequestMapping("/pile")
public class PileController {
    @Autowired
    private PileService pileService;

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody PileConditionDTO pileConditionDTO){
        Page page = pileService.pageAll(pileConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = pileService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = pileService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("增加")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Pile pile){
        boolean result =  pileService.saveOrUpdate(pile);
        return CommonResult.success(result);
    }

}

