package com.qifa.pileportal.dao;

import com.qifa.pileportal.dto.StationCommentDTO;
import com.qifa.pileportal.entity.Pile;
import com.qifa.pileportal.entity.Station;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 电站表 Mapper 接口
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface StationMapper extends BaseMapper<Station> {

    List<Pile> selectPileById(@Param("id") Integer id);

    List<StationCommentDTO> selectCommentById(@Param("id") Integer id);
}
