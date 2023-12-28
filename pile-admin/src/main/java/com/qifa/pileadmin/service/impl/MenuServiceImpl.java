package com.qifa.pileadmin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pileadmin.entity.Menu;
import com.qifa.pileadmin.dao.MenuMapper;
import com.qifa.pileadmin.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * rbac菜单表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<Menu> findMenus(String name) {
        QueryWrapper<Menu> queryWrapper=new QueryWrapper<>();
        if(StrUtil.isNotBlank(name)){
            queryWrapper.like("name",name);
        }
        List<Menu> list = list(queryWrapper);
        // 找出pid为null的一级菜单
        List<Menu> parentNodes=list.stream().filter(menu -> menu.getPid()==null).collect(Collectors.toList());
        //找出一级菜单为null的二级菜单放到Children中
        for(Menu menu:parentNodes){
            menu.setChildren(list.stream().filter(m->menu.getId().equals(m.getPid())).collect(Collectors.toList()));
        }
        return parentNodes;
    }
}
