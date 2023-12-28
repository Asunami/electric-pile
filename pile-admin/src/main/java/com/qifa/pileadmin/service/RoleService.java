package com.qifa.pileadmin.service;

import com.qifa.pileadmin.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface RoleService extends IService<Role> {

    boolean setRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}
