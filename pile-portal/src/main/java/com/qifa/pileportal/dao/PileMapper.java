package com.qifa.pileportal.dao;

import com.qifa.pileportal.dto.StationCommentDTO;
import com.qifa.pileportal.entity.Pile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qifa.pileportal.entity.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 充电桩表 Mapper 接口
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface PileMapper extends BaseMapper<Pile> {

    List<StationCommentDTO> selectCommentById(@Param("id") Integer id);

    List<Reservation> selectReserveById(@Param("id") Integer id);
}
