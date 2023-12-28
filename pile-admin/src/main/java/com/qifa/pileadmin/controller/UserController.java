package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonPage;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.UserConditionDTO;
import com.qifa.pileadmin.entity.User;
import com.qifa.pileadmin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前台用户表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "UserController",description = "用户列表相关管理")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("分页查询所有用户")
    @PostMapping("/page")
    public CommonResult findAll(@RequestBody UserConditionDTO userConditionDTO){
        Page page = userService.pageAll(userConditionDTO);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("根据ID删除用户")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = userService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除用户")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = userService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("增加或编辑用户")
    @PostMapping("/add")
    public CommonResult save(@RequestBody User user){
        boolean result =  userService.saveOrUpdate(user);
        return CommonResult.success(result);
    }



}

