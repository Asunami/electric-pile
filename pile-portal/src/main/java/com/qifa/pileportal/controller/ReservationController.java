package com.qifa.pileportal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.dto.ReservationResDTO;
import com.qifa.pileportal.entity.Reservation;
import com.qifa.pileportal.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 预约表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "ReservationController",description = "预约相关操作")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @ApiOperation("根据用户id查询该用户的预约记录相关信息")
    @GetMapping("/getReserve/{userId}")
    public CommonResult getById(@PathVariable Integer userId){
        List<ReservationResDTO> list = reservationService.listByid(userId);
        return CommonResult.success(list);
    }

    @ApiOperation("删除指定用户其下指定预约记录")
    @DeleteMapping("/deleteReserve/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = reservationService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("根据传来的预约id，将其状态设置为已经开始，并将开始时间设置为现在")
    @GetMapping("/changeToStart/{id}")
    public CommonResult changeStation(@PathVariable Integer id){
        boolean result = reservationService.changeToStart(id);
        return CommonResult.success(result);
    }

    @ApiOperation("根据用户id查询预约记录中状态为正在充电的订单的信息")
    @GetMapping("/getStart/{id}")
    public CommonResult getStartReserve(@PathVariable Integer id){
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        queryWrapper.eq("status",2);
        Reservation reservation = reservationService.getOne(queryWrapper);
        return CommonResult.success(reservation);
    }

}

