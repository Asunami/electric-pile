package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.StationConditionDTO;
import com.qifa.pileadmin.entity.Station;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 电站表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface StationService extends IService<Station> {

    Page pageAll(StationConditionDTO stationConditionDTO);

    boolean updateWithPile(Station station);
}
