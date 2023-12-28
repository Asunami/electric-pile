package com.qifa.pileadmin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileadmin.dao.DictMapper;
import com.qifa.pileadmin.entity.Menu;
import com.qifa.pileadmin.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * rbac菜单表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@RestController
@CrossOrigin
@Api(tags = "MenuController",description = "菜单操作")
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Resource
    private DictMapper dictMapper;

    @ApiOperation("增加菜单")
    @PostMapping("/add")
    public CommonResult save(@RequestBody Menu menu){
        boolean result =  menuService.saveOrUpdate(menu);
        return CommonResult.success(result);
    }

    @ApiOperation("根据id删除菜单")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable Integer id){
        boolean result = menuService.removeById(id);
        return CommonResult.success(result);
    }

    @ApiOperation("批量删除菜单")
    @PostMapping("/delete/batch")
    public CommonResult deletteBatch(@RequestBody List<Integer> ids){
        boolean result = menuService.removeByIds(ids);
        return CommonResult.success(result);
    }

    @ApiOperation("根据id查找菜单")
    @GetMapping("/select/{id}")
    public CommonResult findById(@PathVariable Integer id){
        return CommonResult.success(menuService.getById(id));
    }

    @ApiOperation("分页查找")
    @GetMapping("/select/page")
    public CommonResult findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String name){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        queryWrapper.orderByDesc("id");
        return CommonResult.success(menuService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }

    @ApiOperation("查询全部菜单")
    @GetMapping("/all")
    public CommonResult findAll(@RequestParam(defaultValue = "") String name){
        return CommonResult.success(menuService.findMenus(name));
    }

    @ApiOperation("获取菜单图标")
    @GetMapping("/icons")
    public CommonResult getIcons(){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","icon");
        return CommonResult.success(dictMapper.selectList(null));
    }

    @ApiOperation("查询所有菜单id集合")
    @GetMapping("/ids")
    public CommonResult findAllIds(){
        return CommonResult.success(menuService.list().stream().map(Menu::getId));
    }

}

