package com.qifa.pileadmin.dao;


import com.qifa.pileadmin.dto.StationOrderDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EchartsMapper {
    Integer getOnlineUser(@Param("status") Integer status);

    Integer getOnlineStation(@Param("status") Integer status);

    Integer getOnlinePile(@Param("status") Integer status);

    List<StationOrderDTO> getStationOrderList();
}
