package com.qifa.pileadmin.dao;

import com.qifa.pileadmin.entity.ManagerRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 管理员-角色关联表 Mapper 接口
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface ManagerRoleMapper extends BaseMapper<ManagerRole> {

    List<Integer> selectByMid(@Param("managerId") Integer managerId);

    int deleteByMid(@Param("managerId") Integer managerId);
}
