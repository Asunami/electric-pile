package com.qifa.pileadmin.dao;

import com.qifa.pileadmin.entity.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 后台管理员表 Mapper 接口
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface ManagerMapper extends BaseMapper<Manager> {
    String selectRoleById(@Param("id")Integer id);

}
