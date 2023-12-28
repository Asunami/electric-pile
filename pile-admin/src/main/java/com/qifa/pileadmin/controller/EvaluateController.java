package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.EvaluateConditionDTO;
import com.qifa.pileadmin.entity.Evaluate;
import com.qifa.pileadmin.service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 评价表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "EvaluateController",description = "评价记录相关")
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody EvaluateConditionDTO evaluateConditionDTO){
        Page page = evaluateService.pageAll(evaluateConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = evaluateService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = evaluateService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("增加或编辑")
    @PostMapping("/addOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody Evaluate entity){
        boolean result =  evaluateService.saveOrUpdate(entity);
        return CommonResult.success(result);
    }

}

