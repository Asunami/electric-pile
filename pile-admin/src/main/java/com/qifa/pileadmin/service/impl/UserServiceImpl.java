package com.qifa.pileadmin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.UserConditionDTO;
import com.qifa.pileadmin.entity.User;
import com.qifa.pileadmin.dao.UserMapper;
import com.qifa.pileadmin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 前台用户表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page pageAll(UserConditionDTO userConditionDTO) {
        Page page = new Page<>(userConditionDTO.getPageNum(),userConditionDTO.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<User> lambdaQueryWrapper = queryWrapper.lambda();
        if(!StrUtil.isBlank(userConditionDTO.getUsername())){
            lambdaQueryWrapper.like(User::getUsername,userConditionDTO.getUsername());
        }
        if(!StrUtil.isBlank(userConditionDTO.getNickname())){
            lambdaQueryWrapper.like(User::getNickname,userConditionDTO.getNickname());
        }
        if(!StrUtil.isBlank(userConditionDTO.getPhone())){
            lambdaQueryWrapper.like(User::getPhone,userConditionDTO.getPhone());
        }
        return this.page(page,lambdaQueryWrapper);
    }
}
