package com.qifa.pileportal.controller;


import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.api.CommonResult;
import com.qifa.pileportal.dto.UserLoginDTO;
import com.qifa.pileportal.entity.User;
import com.qifa.pileportal.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前台用户表 前端控制器
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@RestController
@Api(tags = "UserController",description = "前台用户登录相关")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public CommonResult login(@RequestBody UserLoginDTO userLoginDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userLoginDTO.getUsername());
        User user = userService.getOne(queryWrapper);
        if(user == null){
            return CommonResult.failed("用户不存在！");
        }
        if(!BCrypt.checkpw(userLoginDTO.getPassword(),user.getPassword())){
            return CommonResult.failed("密码错误！");
        }
        if (user.getStatus()==0){
                return CommonResult.failed("该账号涉嫌违规已被禁用");
        }
        UserLoginDTO dto = userService.getUserMessage(user);
        return CommonResult.success(dto);
    }

    @ApiOperation("根据用户id获取用户信息")
    @GetMapping("/information/{id}")
    public CommonResult getInformation(@PathVariable Integer id){
        return CommonResult.success(userService.getById(id));
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout/{id}")
    public CommonResult loginout(@PathVariable Integer id){
        Boolean result = userService.logout(id);
        return CommonResult.success(result);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public CommonResult register(@RequestBody User user){
        boolean result = userService.register(user);
        if(result){
            return CommonResult.success("注册成功！");
        }else {
            return CommonResult.failed("用户名已存在");
        }

    }

    @ApiOperation("编辑用户")
    @PostMapping("/add")
    public CommonResult save(@RequestBody User user){
        boolean result =  userService.saveOrUpdate(user);
        return CommonResult.success(result);
    }

}

