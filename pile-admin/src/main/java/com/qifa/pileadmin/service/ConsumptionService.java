package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.ConsumptionConditionDTO;
import com.qifa.pileadmin.entity.Consumption;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 消费记录表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface ConsumptionService extends IService<Consumption> {

    Page pageAll(ConsumptionConditionDTO consumptionConditionDTO);
}
