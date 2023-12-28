package com.qifa.pileportal.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.dto.StationReqConditionDTO;
import com.qifa.pileportal.dto.SystemInfoDTO;
import com.qifa.pileportal.service.StationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 电站表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "StationController",description = "电站处理相关")
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @ApiOperation("分页获取指定数量电站信息")
    @GetMapping("/some")
    public CommonResult findSome(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "3") Integer pageSize){
        return CommonResult.success(stationService.page(new Page<>(pageNum,pageSize)));
    }

    @ApiOperation("根据id获取指定电站的信息")
    @GetMapping("/detail/{id}")
    public CommonResult findById(@PathVariable Integer id){
        return CommonResult.success(stationService.getById(id));
    }

    @ApiOperation("根据电站id获取指定电站其下所有电桩信息")
    @GetMapping("/detailPile/{id}")
    public CommonResult findChildById(@PathVariable Integer id){
        return CommonResult.success(stationService.findById(id));
    }

    @ApiOperation("根据电站id获取其评论")
    @GetMapping("/comment/{id}")
    public CommonResult findCommentById(@PathVariable Integer id){
        return CommonResult.success(stationService.findCommentById(id));
    }

    @ApiOperation("根据传入的参数筛选获取电站列表")
    @PostMapping("/selectAll")
    public CommonResult selectAll(@RequestBody StationReqConditionDTO reqConditionDTO){
        Page page = stationService.selectAllStation(reqConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("获取系统相关信息")
    @GetMapping("/systemInfo")
    public CommonResult getSystemInfo(){
        SystemInfoDTO systemInfoDTO = stationService.getSystemInfo();
        return CommonResult.success(systemInfoDTO);
    }
}

