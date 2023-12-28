package com.qifa.pileportal.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pilecommon.utils.DistanceUtil;
import com.qifa.pileportal.dao.PileMapper;
import com.qifa.pileportal.dao.UserMapper;
import com.qifa.pileportal.dto.StationCommentDTO;
import com.qifa.pileportal.dto.StationReqConditionDTO;
import com.qifa.pileportal.dto.SystemInfoDTO;
import com.qifa.pileportal.entity.Pile;
import com.qifa.pileportal.entity.Station;
import com.qifa.pileportal.dao.StationMapper;
import com.qifa.pileportal.entity.User;
import com.qifa.pileportal.service.StationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 电站表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements StationService {
    @Resource
    private StationMapper stationMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private PileMapper pileMapper;


    @Override
    public List<Pile> findById(Integer id) {
        return stationMapper.selectPileById(id);
    }

    @Override
    public List<StationCommentDTO> findCommentById(Integer id) {
        return stationMapper.selectCommentById(id);
    }

    @Override
    public Page selectAllStation(StationReqConditionDTO reqConditionDTO) {
        Page<Station> page = new Page<>(reqConditionDTO.getPageNum(), reqConditionDTO.getPageSize());
        QueryWrapper<Station> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Station> lambdaQueryWrapper = queryWrapper.lambda();
        if (!StrUtil.isBlank(reqConditionDTO.getName())) {
            lambdaQueryWrapper.like(Station::getName, reqConditionDTO.getName());
        }
        if (!StrUtil.isBlank(reqConditionDTO.getAddress())) {
            lambdaQueryWrapper.like(Station::getAddress, reqConditionDTO.getAddress());
        }
        Page<Station> stations = stationMapper.selectPage(page, lambdaQueryWrapper);
        if (reqConditionDTO.getLatitude() != null && reqConditionDTO.getLongitude() != null) {
            for (Station station : stations.getRecords()) {
                Double distance = DistanceUtil.distanceOfTwoPoints(reqConditionDTO.getLatitude(), reqConditionDTO.getLongitude(), station.getLatitude(), station.getLongitude());
                station.setDistance(distance);
            }
            //根据距离排序
            if (reqConditionDTO.getSort() == 2) {
                Collections.sort(stations.getRecords(), new Comparator<Station>() {
                    public int compare(Station o1, Station o2) {
                        return o1.getDistance().compareTo(o2.getDistance());
                    }
                });
            }
        }
        return stations;
    }

    @Override
    public SystemInfoDTO getSystemInfo() {
        SystemInfoDTO systemInfoDTO = new SystemInfoDTO();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("status",2);
        systemInfoDTO.setOnlineUser(userMapper.selectCount(userQueryWrapper));

        QueryWrapper<Station> stationQueryWrapper = new QueryWrapper<>();
        stationQueryWrapper.eq("status",1);
        systemInfoDTO.setOpenStation(stationMapper.selectCount(stationQueryWrapper));

        QueryWrapper<Pile> pileQueryWrapper = new QueryWrapper<>();
        pileQueryWrapper.eq("status",1);
        systemInfoDTO.setUsablePile(pileMapper.selectCount(pileQueryWrapper));
        return systemInfoDTO;
    }

}
