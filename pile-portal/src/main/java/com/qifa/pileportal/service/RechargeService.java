package com.qifa.pileportal.service;

import com.qifa.pileportal.entity.Recharge;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 充值记录表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface RechargeService extends IService<Recharge> {

    boolean pay(Recharge recharge);
}
