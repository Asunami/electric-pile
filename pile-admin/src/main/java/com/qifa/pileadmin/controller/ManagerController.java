package com.qifa.pileadmin.controller;


import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dto.ManagerLoginDTO;
import com.qifa.pileadmin.entity.Manager;
import com.qifa.pileadmin.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 后台管理员表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "ManagerController",description = "管理员相关控制")
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @ApiOperation("登录并返回前端需要字段")
    @PostMapping("/login")
    public CommonResult login(@RequestBody ManagerLoginDTO loginDTO){
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",loginDTO.getUsername());
        Manager manager = managerService.getOne(queryWrapper);
        if(manager == null){
            return CommonResult.failed("用户不存在");
        }
        if(!BCrypt.checkpw(loginDTO.getPassword(),manager.getPassword())){
            return CommonResult.failed("密码错误！");
        }
        if (manager.getStatus() == 1) {
            return CommonResult.failed("该账号已被停用！！");
        }
        ManagerLoginDTO dto = managerService.getManagerPermission(manager);
        return CommonResult.success(dto);
    }

    @ApiOperation("电站管理员注册")
    @PostMapping("/register")
    public CommonResult register(@RequestBody Manager manager){
        String encodePassword = BCrypt.hashpw(manager.getPassword());
        manager.setPassword(encodePassword);
        boolean result = managerService.save(manager);
        return CommonResult.success(result,"注册成功，请等待超级管理员审核");
    }

    @ApiOperation("增加管理员")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Manager manager){
        String encodePassword = BCrypt.hashpw(manager.getPassword());
        manager.setPassword(encodePassword);
        boolean result =  managerService.saveOrUpdate(manager);
        return CommonResult.success(result);
    }

    @ApiOperation("审核通过")
    @PostMapping("/checkPass")
    public CommonResult checkPass(@RequestBody Manager manager){
        manager.setRemark("pass");
        boolean result =  managerService.updateById(manager);
        return CommonResult.success(result);
    }

    @ApiOperation("根据ID删除管理员")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = managerService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除管理员")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = managerService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("查询未审核管理员")
    @GetMapping("/waitCheck")
    public CommonResult findNoCheck(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String name) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", name);
        queryWrapper.eq("status", 1);
        queryWrapper.notLike("remark","pass");
        return CommonResult.success(managerService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @ApiOperation("根据id查找管理员")
    @GetMapping("select/{id}")
    public CommonResult findById(@PathVariable Integer id){
        return CommonResult.success(managerService.getById(id));
    }

    @ApiOperation("分页查找管理员")
    @GetMapping("/page")
    public CommonResult findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String name){
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username",name);
        queryWrapper.eq("remark","pass");
        queryWrapper.orderByAsc("id");
        return CommonResult.success(managerService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }
    @ApiOperation("得到已经绑定角色")
    @GetMapping("/managerRole/{managerId}")
    public CommonResult getManagerRole(@PathVariable Integer managerId){
        return CommonResult.success(managerService.getManagerRole(managerId));
    }

    @ApiOperation("重新绑定管理员和角色关系")
    @PostMapping("/managerRole/{managerId}")
    public CommonResult managerRole(@PathVariable Integer managerId,@RequestBody List<Integer> roleIds){
        boolean result = managerService.setManagerRole(managerId,roleIds);
        return CommonResult.success(result);
    }


}

