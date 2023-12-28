package com.qifa.pileadmin.service;

import com.qifa.pileadmin.dto.StationOrderDTO;
import com.qifa.pileadmin.dto.SystemStatusInfoDTO;

import java.util.List;

public interface EchartsService {
    SystemStatusInfoDTO getOnlineInfo();

    List<StationOrderDTO> getStationOrder();
}
