package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.ReservationConditionDTO;
import com.qifa.pileadmin.entity.Reservation;
import com.qifa.pileadmin.service.ReservationService;
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
 * @since 2023-05-07
 */
@RestController
@Api(tags = "ReservationController",description = "预约相关操作")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @ApiOperation("根据用户id查询预约记录")
    @GetMapping("/getAll")
    public CommonResult getAllById(){
        return CommonResult.success(reservationService.list());
    }

    @ApiOperation("分页查询所有")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody ReservationConditionDTO reservationConditionDTO){
        Page page = reservationService.pageAll(reservationConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = reservationService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = reservationService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("编辑")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Reservation reservation){
        boolean result =  reservationService.saveOrUpdate(reservation);
        return CommonResult.success(result);
    }
}

