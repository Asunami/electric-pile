package com.qifa.pileportal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileportal.dto.StationCommentDTO;
import com.qifa.pileportal.dto.StationReqConditionDTO;
import com.qifa.pileportal.dto.SystemInfoDTO;
import com.qifa.pileportal.entity.Pile;
import com.qifa.pileportal.entity.Station;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 电站表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface StationService extends IService<Station> {

    List<Pile> findById(Integer id);

    List<StationCommentDTO> findCommentById(Integer id);

    Page selectAllStation(StationReqConditionDTO reqConditionDTO);

    SystemInfoDTO getSystemInfo();
}
