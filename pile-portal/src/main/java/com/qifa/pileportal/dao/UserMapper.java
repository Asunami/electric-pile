package com.qifa.pileportal.dao;

import com.qifa.pileportal.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 前台用户表 Mapper 接口
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface UserMapper extends BaseMapper<User> {

    Integer checkUserExist(@Param("username") String username);

    void setUserStatus(Integer status, Integer id);
}
