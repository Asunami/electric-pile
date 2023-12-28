package com.qifa.pileadmin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.qifa.pileadmin.util.JwtUtilForManager;
import com.qifa.pileadmin.dao.ManagerRoleMapper;
import com.qifa.pileadmin.dao.RoleMapper;
import com.qifa.pileadmin.dao.RoleMenuMapper;
import com.qifa.pileadmin.dto.ManagerLoginDTO;
import com.qifa.pileadmin.entity.Manager;
import com.qifa.pileadmin.dao.ManagerMapper;
import com.qifa.pileadmin.entity.ManagerRole;
import com.qifa.pileadmin.entity.Menu;
import com.qifa.pileadmin.service.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qifa.pileadmin.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 后台管理员表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private ManagerRoleMapper managerRoleMapper;

    @Resource
    private MenuService menuService;

    @Override
    public ManagerLoginDTO getManagerPermission(Manager manager) {
        ManagerLoginDTO loginDTO = new ManagerLoginDTO();
        BeanUtil.copyProperties(manager, loginDTO, true);
        String token = JwtUtilForManager.sign(manager);
        loginDTO.setToken(token);
        Integer menuId = manager.getId();
        String role = managerMapper.selectRoleById(menuId);
        List<Menu> roleMenus = getRoleMenus(menuId);
        loginDTO.setMenus(roleMenus);
        loginDTO.setRole(role);
        return loginDTO;
    }

    @Override
    public List<Integer> getManagerRole(Integer managerId) {
        return managerRoleMapper.selectByMid(managerId);
    }

    @Override
    public boolean setManagerRole(Integer managerId, List<Integer> roleIds) {
        managerRoleMapper.deleteByMid(managerId);
        for (Integer roleId : roleIds) {
            ManagerRole managerRole = new ManagerRole();
            managerRole.setManagerId(managerId);
            managerRole.setRoleId(roleId);
            managerRoleMapper.insert(managerRole);
        }
        return false;
    }

    private List<Menu> getRoleMenus(Integer menuId) {
        //根据管理员ID获取角色Id
        Integer roleId = roleMapper.selectRidByMid(menuId);
        //当前角色Id的所有菜单id集合
        List<Integer> menuIds = roleMenuMapper.selectByRoleId(roleId);
        //查出系统所有菜单
        List<Menu> menus = menuService.findMenus("");
        //筛选当前用户菜单
        List<Menu> roleMenus = new ArrayList<>();
        for (Menu menu : menus) {
            if (menuIds.contains(menu.getId())) {
                roleMenus.add(menu);
            }
            List<Menu> children = menu.getChildren();
            //removeIf移除children里面不在menuIds集合中的元素
            children.removeIf(child -> !menuIds.contains(child.getId()));
        }
        return roleMenus;
    }
}
