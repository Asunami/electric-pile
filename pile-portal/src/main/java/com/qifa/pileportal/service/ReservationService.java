package com.qifa.pileportal.service;

import com.qifa.pileportal.dto.ReservationResDTO;
import com.qifa.pileportal.entity.Reservation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 预约表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface ReservationService extends IService<Reservation> {

    List<ReservationResDTO> listByid(Integer userId);

    boolean changeToStart(Integer id);
}
