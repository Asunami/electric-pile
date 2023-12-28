package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.ReservationConditionDTO;
import com.qifa.pileadmin.entity.Reservation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 预约表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface ReservationService extends IService<Reservation> {

    Page pageAll(ReservationConditionDTO reservationConditionDTO);
}
