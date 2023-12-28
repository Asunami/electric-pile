package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.UserConditionDTO;
import com.qifa.pileadmin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 前台用户表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface UserService extends IService<User> {

    Page pageAll(UserConditionDTO userConditionDTO);
}
