package com.qifa.pileadmin.service.impl;

import com.qifa.pileadmin.dao.RoleMenuMapper;
import com.qifa.pileadmin.entity.Menu;
import com.qifa.pileadmin.entity.Role;
import com.qifa.pileadmin.dao.RoleMapper;
import com.qifa.pileadmin.entity.RoleMenu;
import com.qifa.pileadmin.service.MenuService;
import com.qifa.pileadmin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private MenuService menuService;

    @Transactional
    @Override
    public boolean setRoleMenu(Integer roleId, List<Integer> menuIds){
        roleMenuMapper.deleteByRoleId(roleId);
        for(Integer menuId: menuIds){
            Menu menu = menuService.getById(menuId);
            if(menu.getPid() != null && !menuIds.contains(menu.getPid())){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menuId);
                roleMenuMapper.insert(roleMenu);
            }
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
        return false;
    }

    @Override
    public List<Integer> getRoleMenu(Integer roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }

}
