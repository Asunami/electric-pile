package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.RechargeConditionDTO;
import com.qifa.pileadmin.entity.Recharge;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 充值记录表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface RechargeService extends IService<Recharge> {

    Page pageAll(RechargeConditionDTO rechargeConditionDTO);
}
