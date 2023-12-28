package com.qifa.pileportal.service;

import com.qifa.pileportal.dto.StationCommentDTO;
import com.qifa.pileportal.entity.Pile;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qifa.pileportal.entity.Reservation;

import java.util.List;

/**
 * <p>
 * 充电桩表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface PileService extends IService<Pile> {

    List<StationCommentDTO> findCommentById(Integer id);

    List<Reservation> findReserveById(Integer id);

    boolean checkUsable(Reservation reservation);
}
