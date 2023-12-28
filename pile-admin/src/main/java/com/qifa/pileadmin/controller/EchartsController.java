package com.qifa.pileadmin.controller;


import com.qifa.pileadmin.dto.StationOrderDTO;
import com.qifa.pileadmin.dto.SystemStatusInfoDTO;
import com.qifa.pileadmin.entity.EchartsPie;
import com.qifa.pileadmin.service.EchartsService;
import com.qifa.pilecommon.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页Echarts展示 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "EchartsController",description = "后台首页Echarts展示相关")
@RequestMapping("/echarts")
public class EchartsController {

    @Autowired
    private EchartsService echartsService;

    @ApiOperation("获取各种状态数据信息")
    @GetMapping("/onlinePie")
    public CommonResult onlinePie() {
        SystemStatusInfoDTO infoDTO = echartsService.getOnlineInfo();
        return CommonResult.success(infoDTO);
    }

    @ApiOperation("获取各种状态数据信息")
    @GetMapping("/order")
    public CommonResult orderNumber() {
        List<StationOrderDTO> list = echartsService.getStationOrder();
        return CommonResult.success(list);
    }



}
