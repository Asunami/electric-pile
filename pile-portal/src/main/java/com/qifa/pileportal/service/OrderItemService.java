package com.qifa.pileportal.service;

import com.qifa.pileportal.dto.OrderPayDTO;
import com.qifa.pileportal.entity.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface OrderItemService extends IService<OrderItem> {

    boolean doManyThing(OrderPayDTO payDTO);

    boolean payNow(Integer id);

    boolean checkIfPay(Integer id);
}
