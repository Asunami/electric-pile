package com.qifa.pileadmin.service;

import com.qifa.pileadmin.dto.ManagerLoginDTO;
import com.qifa.pileadmin.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台管理员表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface ManagerService extends IService<Manager> {

    ManagerLoginDTO getManagerPermission(Manager manager);

    List<Integer> getManagerRole(Integer managerId);

    boolean setManagerRole(Integer managerId, List<Integer> roleIds);

}
