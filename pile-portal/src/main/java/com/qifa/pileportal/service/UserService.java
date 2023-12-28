package com.qifa.pileportal.service;

import com.qifa.pileportal.dto.UserLoginDTO;
import com.qifa.pileportal.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 前台用户表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface UserService extends IService<User> {

    boolean register(User user);

    Boolean logout(Integer id);

    UserLoginDTO getUserMessage(User user);
}
