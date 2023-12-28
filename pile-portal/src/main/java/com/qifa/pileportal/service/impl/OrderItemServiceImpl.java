package com.qifa.pileportal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pileportal.dao.*;
import com.qifa.pileportal.dto.OrderPayDTO;
import com.qifa.pileportal.entity.*;
import com.qifa.pileportal.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
    @Resource
    private OrderItemMapper orderMapper;

    @Resource
    private ReservationMapper reservationMapper;

    @Resource
    private ConsumptionMapper consumptionMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private PileMapper pileMapper;

    @Override
    public boolean doManyThing(OrderPayDTO payDTO) {
        //无论是否支付都会执行的操作
        //1.更新预约记录状态
        Reservation reservation = reservationMapper.selectById(payDTO.getReservationId());
        reservation.setStatus(3);
        reservation.setOverTime(new Date());
        reservationMapper.updateById(reservation);
        //2.更新充电桩状态
        Pile pile = pileMapper.selectById(payDTO.getPileId());
        pile.setStatus(1);
        pileMapper.updateById(pile);


        //点击结束，并未支付,不生成消费记录
        if (payDTO.getStatus() == 1) {
            //2.新增订单记录
            OrderItem orderItem = new OrderItem();
            BeanUtil.copyProperties(payDTO, orderItem, true);
            orderItem.setOverTime(new Date());
            System.out.println(orderItem);
            orderMapper.insert(orderItem);

            return true;

        } else {
            //2.新增订单记录
            OrderItem orderItem = new OrderItem();
            BeanUtil.copyProperties(payDTO, orderItem, true);
            orderItem.setOverTime(new Date());
            orderMapper.insert(orderItem);

            //3.新增消费记录
            Consumption consumption = new Consumption();
            QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("reservation_id", payDTO.getReservationId());
            OrderItem order = orderMapper.selectOne(queryWrapper);
            consumption.setUserId(payDTO.getUserId());
            consumption.setOrderId(order.getId());
            consumption.setMoney(payDTO.getMoney());
            consumption.setSpendTime(new Date());
            consumption.setCreatTime(new Date());
            consumptionMapper.insert(consumption);

            //4.更新用户余额
            User user = userMapper.selectById(payDTO.getUserId());
            user.setBalance(user.getBalance().subtract(payDTO.getMoney()));
            userMapper.updateById(user);

            return true;
        }
    }

    @Override
    public boolean payNow(Integer id) {
        //更新订单状态
        OrderItem order = orderMapper.selectById(id);
        order.setStatus(2);
        orderMapper.updateById(order);
        //新增消费记录
        Consumption one= new Consumption();
        one.setUserId(order.getUserId());
        one.setOrderId(order.getId());
        one.setMoney(order.getMoney());
        one.setSpendTime(new Date());
        one.setCreatTime(new Date());
        consumptionMapper.insert(one);

        //更新用户余额
        User user = userMapper.selectById(order.getUserId());
        user.setBalance(user.getBalance().subtract(order.getMoney()));
        userMapper.updateById(user);

        return true;
    }

    @Override
    public boolean checkIfPay(Integer id) {
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        queryWrapper.eq("status",1);
        List<OrderItem> list = orderMapper.selectList(queryWrapper);
        if(list.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
