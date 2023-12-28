package com.qifa.pileadmin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.ReservationConditionDTO;
import com.qifa.pileadmin.entity.Reservation;
import com.qifa.pileadmin.dao.ReservationMapper;
import com.qifa.pileadmin.service.ReservationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 预约表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation> implements ReservationService {
    @Resource
    private ReservationMapper reservationMapper;

    @Override
    public Page pageAll(ReservationConditionDTO reservationConditionDTO) {
        Page page = new Page<>(reservationConditionDTO.getPageNum(),reservationConditionDTO.getPageSize());
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Reservation> lambdaQueryWrapper = queryWrapper.lambda();
        if(reservationConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Reservation::getId,reservationConditionDTO.getId());
        }
        if (reservationConditionDTO.getUserId() != null){
            lambdaQueryWrapper.like(Reservation::getUserId,reservationConditionDTO.getUserId());
        }
        if (reservationConditionDTO.getPileId() != null){
            lambdaQueryWrapper.like(Reservation::getPileId,reservationConditionDTO.getPileId());
        }
        if (reservationConditionDTO.getStatus() != null){
            lambdaQueryWrapper.like(Reservation::getStatus,reservationConditionDTO.getStatus());
        }
        return this.page(page,lambdaQueryWrapper);
    }
}
