package com.qifa.pileadmin.dao;

import com.qifa.pileadmin.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色-权限关联表 Mapper 接口
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    int deleteByRoleId(@Param("roleId") Integer roleId);

    List<Integer> selectByRoleId(@Param("roleId") Integer roleId);

}
