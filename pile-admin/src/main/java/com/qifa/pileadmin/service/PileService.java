package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.PileConditionDTO;
import com.qifa.pileadmin.entity.Pile;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 充电桩表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface PileService extends IService<Pile> {

    Page pageAll(PileConditionDTO pileConditionDTO);
}
