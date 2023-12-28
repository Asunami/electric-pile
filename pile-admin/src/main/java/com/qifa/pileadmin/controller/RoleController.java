package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.entity.Role;
import com.qifa.pileadmin.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@Api(tags = "RoleController",description = "角色控制模块")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("增加角色")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Role role){
        boolean result =  roleService.saveOrUpdate(role);
        return CommonResult.success(result);
    }

    @ApiOperation("根据ID删除角色")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = roleService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除角色")
    @PostMapping("/deleteBatch")
    public CommonResult deleteBatch(@RequestBody List<Integer> ids){
        boolean result = roleService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("查询全部角色")
    @GetMapping("/all")
    public CommonResult findAll(){
        return CommonResult.success(roleService.list());
    }

    @ApiOperation("根据id查找角色")
    @GetMapping("select/{id}")
    public CommonResult findById(@PathVariable Integer id){
        return CommonResult.success(roleService.getById(id));
    }

    @ApiOperation("分页查找角色")
    @GetMapping("/page")
    public CommonResult findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String name){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        queryWrapper.orderByAsc("id");
        return CommonResult.success(roleService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }

    @ApiOperation("得到已经绑定菜单")
    @GetMapping("/roleMenu/{roleId}")
    public CommonResult getRoleMenu(@PathVariable Integer roleId){
        return CommonResult.success(roleService.getRoleMenu(roleId));
    }

    @ApiOperation("重新绑定角色和菜单关系")
    @PostMapping("/roleMenu/{roleId}")
    public CommonResult roleMenu(@PathVariable Integer roleId,@RequestBody List<Integer> menuIds){
        boolean result = roleService.setRoleMenu(roleId,menuIds);
        return CommonResult.success(result);
    }

    @ApiOperation("查询所有角色id集合")
    @GetMapping("/ids")
    public CommonResult findAllIds(){
        return CommonResult.success(roleService.list().stream().map(Role::getId));
    }
}

