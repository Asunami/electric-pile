package com.qifa.pileportal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pilecommon.exception.ApiException;
import com.qifa.pileportal.dto.UserLoginDTO;
import com.qifa.pileportal.entity.User;
import com.qifa.pileportal.dao.UserMapper;
import com.qifa.pileportal.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qifa.pileportal.util.JwtUtilForUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 前台用户表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserLoginDTO getUserMessage(User user) {
        user.setStatus(2);
        userMapper.updateById(user);
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        BeanUtil.copyProperties(user, userLoginDTO, true);
        String token = JwtUtilForUser.sign(user);
        userLoginDTO.setToken(token);
        return userLoginDTO;
    }

    @Override
    public Boolean logout(Integer id) {
        userMapper.setUserStatus(1, id);
        return true;
    }

    @Override
    public boolean register(User user) {
        Integer exist = userMapper.checkUserExist(user.getUsername());
        if (exist == 0) {
            String encodePassword = BCrypt.hashpw(user.getPassword());
            user.setPassword(encodePassword);
            BigDecimal decimal = new BigDecimal(0);
            user.setBalance(decimal);
            userMapper.insert(user);
            return true;
        } else {
            return false;
        }
    }

}
