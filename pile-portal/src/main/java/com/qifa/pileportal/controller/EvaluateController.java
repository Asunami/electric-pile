package com.qifa.pileportal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.entity.Evaluate;
import com.qifa.pileportal.service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 评价表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "EvaluateController",description = "评价操作相关")
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation("新增评价")
    @PostMapping("/addNew")
    public CommonResult addNewEva(@RequestBody Evaluate evaluate){
        boolean result = evaluateService.addNewEva(evaluate);
        return CommonResult.success(result);
    }

    @ApiOperation("根据订单id获取评价详情")
    @GetMapping("/getByOid/{id}")
    public CommonResult getEvaByOid(@PathVariable Integer orderId){
        QueryWrapper<Evaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id",orderId);
        Evaluate evaluate = evaluateService.getOne(queryWrapper);
        return CommonResult.success(evaluate);
    }
}

