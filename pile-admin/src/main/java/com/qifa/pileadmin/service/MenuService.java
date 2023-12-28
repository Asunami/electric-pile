package com.qifa.pileadmin.service;

import com.qifa.pileadmin.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * rbac菜单表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface MenuService extends IService<Menu> {

    List<Menu> findMenus(String name);
}
