package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.WarnConditionDTO;
import com.qifa.pileadmin.entity.Warn;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 告警记录表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface WarnService extends IService<Warn> {

    Page pageAll(WarnConditionDTO warnConditionDTO);
}
