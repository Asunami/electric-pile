package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.OrderConditionDTO;
import com.qifa.pileadmin.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface OrderService extends IService<Order> {

    Page<Order> pageAll(OrderConditionDTO orderConditionDTO);
}
