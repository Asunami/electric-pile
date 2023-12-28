package com.qifa.pileportal.controller;


import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.entity.Reservation;
import com.qifa.pileportal.service.PileService;
import com.qifa.pileportal.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 充电桩表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "PileController",description = "电桩操作相关")
@RequestMapping("/pile")
public class PileController {
    @Autowired
    private PileService pileService;
    @Autowired
    private ReservationService reservationService;

    @ApiOperation("根据id获取指定充电桩的信息")
    @GetMapping("/detail/{id}")
    public CommonResult findById(@PathVariable Integer id){
        return CommonResult.success(pileService.getById(id));
    }

    @ApiOperation("根据充电桩id获取指定电桩其下没有过期的预约记录信息")
    @GetMapping("/reservation/{id}")
    public CommonResult findChildById(@PathVariable Integer id){
        return CommonResult.success(pileService.findReserveById(id));
    }

    @ApiOperation("根据充电桩id获取其评论")
    @GetMapping("/comment/{id}")
    public CommonResult findCommentById(@PathVariable Integer id){
        return CommonResult.success(pileService.findCommentById(id));
    }

    @ApiOperation("检查预约时间段是否有效")
    @PostMapping("/checkUsable")
    public CommonResult checkUsable(@RequestBody Reservation reservation) {
        boolean result = pileService.checkUsable(reservation);
        return CommonResult.success(result);
    }

    @ApiOperation("插入预约记录")
    @PostMapping("/addReservation")
    public CommonResult addReservation(@RequestBody Reservation reservation){
        boolean result = reservationService.saveOrUpdate(reservation);
        return CommonResult.success(result);
    }

}

