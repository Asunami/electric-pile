package com.qifa.pileadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.OrderConditionDTO;
import com.qifa.pileadmin.entity.Order;
import com.qifa.pileadmin.dao.OrderMapper;
import com.qifa.pileadmin.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public Page<Order> pageAll(OrderConditionDTO orderConditionDTO) {
        Page<Order> page = new Page<>(orderConditionDTO.getPageNum(),orderConditionDTO.getPageSize());
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Order> lambdaQueryWrapper = queryWrapper.lambda();
        if(orderConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Order::getId,orderConditionDTO.getId());
        }
        if (orderConditionDTO.getUserId() != null){
            lambdaQueryWrapper.like(Order::getUserId,orderConditionDTO.getUserId());
        }
        if (orderConditionDTO.getPileId() != null){
            lambdaQueryWrapper.like(Order::getPileId,orderConditionDTO.getPileId());
        }
        if (orderConditionDTO.getStatus() != null){
            lambdaQueryWrapper.like(Order::getStatus,orderConditionDTO.getStatus());
        }
        return this.page(page,lambdaQueryWrapper);
    }
}
