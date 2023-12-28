package com.qifa.pileadmin.service.impl;

import com.qifa.pileadmin.dao.EchartsMapper;
import com.qifa.pileadmin.dto.StationOrderDTO;
import com.qifa.pileadmin.dto.SystemStatusInfoDTO;
import com.qifa.pileadmin.entity.EchartsPie;
import com.qifa.pileadmin.service.EchartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EchartsServiceImpl implements EchartsService {
    @Resource
    EchartsMapper echartsMapper;

    @Override
    public SystemStatusInfoDTO getOnlineInfo() {
        SystemStatusInfoDTO infoDTO = new SystemStatusInfoDTO();
        //用户
        List<EchartsPie> userOnline = new ArrayList<>();
        EchartsPie echartsPie1 = new EchartsPie();
        EchartsPie echartsPie2 = new EchartsPie();
        Integer onlineUser = echartsMapper.getOnlineUser(2);
        Integer offlineUser = echartsMapper.getOnlineUser(1);
        echartsPie1.setValue(onlineUser);
        echartsPie1.setName("在线");
        echartsPie2.setValue(offlineUser);
        echartsPie2.setName("离线");
        userOnline.add(echartsPie1);
        userOnline.add(echartsPie2);
        infoDTO.setUser(userOnline);

        //电站
        List<EchartsPie> stationOnline = new ArrayList<>();
        EchartsPie echartsPie3 = new EchartsPie();
        EchartsPie echartsPie4 = new EchartsPie();
        EchartsPie echartsPie5 = new EchartsPie();
        Integer onlineStation = echartsMapper.getOnlineStation(1);
        Integer closeStation = echartsMapper.getOnlineStation(3);
        Integer offlineStation = echartsMapper.getOnlineStation(2);
        echartsPie3.setValue(onlineStation);
        echartsPie3.setName("营业中");
        echartsPie4.setValue(closeStation);
        echartsPie4.setName("停业中");
        echartsPie5.setValue(offlineStation);
        echartsPie5.setName("休息中");
        stationOnline.add(echartsPie3);
        stationOnline.add(echartsPie4);
        stationOnline.add(echartsPie5);
        infoDTO.setStation(stationOnline);

        //电桩
        List<EchartsPie> pileOnline = new ArrayList<>();
        Integer usablePile = echartsMapper.getOnlinePile(1);
        Integer chargePile = echartsMapper.getOnlinePile(2);
        Integer warnPile = echartsMapper.getOnlinePile(3);
        Integer unUsablePile = echartsMapper.getOnlinePile(4);
        EchartsPie echartsPie6 = new EchartsPie();
        EchartsPie echartsPie7 = new EchartsPie();
        EchartsPie echartsPie8 = new EchartsPie();
        EchartsPie echartsPie9 = new EchartsPie();
        echartsPie6.setName("空闲");
        echartsPie6.setValue(usablePile);
        echartsPie7.setName("充电中");
        echartsPie7.setValue(chargePile);
        echartsPie8.setName("故障");
        echartsPie8.setValue(warnPile);
        echartsPie9.setValue(unUsablePile);
        echartsPie9.setName("不可用");
        pileOnline.add(echartsPie6);
        pileOnline.add(echartsPie7);
        pileOnline.add(echartsPie8);
        pileOnline.add(echartsPie9);
        infoDTO.setPile(pileOnline);

        return infoDTO;
    }

    @Override
    public List<StationOrderDTO> getStationOrder() {
        List<StationOrderDTO> list = echartsMapper.getStationOrderList();
        return list;
    }

}
