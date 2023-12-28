package com.qifa.pileportal.dao;

import com.qifa.pileportal.dto.ReservationResDTO;
import com.qifa.pileportal.entity.Reservation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 预约表 Mapper 接口
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface ReservationMapper extends BaseMapper<Reservation> {

    List<ReservationResDTO> selectListById(@Param("id") Integer userId);
}
