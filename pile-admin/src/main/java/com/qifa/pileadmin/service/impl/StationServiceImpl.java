package com.qifa.pileadmin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dao.PileMapper;
import com.qifa.pileadmin.dto.StationConditionDTO;
import com.qifa.pileadmin.entity.Pile;
import com.qifa.pileadmin.entity.Station;
import com.qifa.pileadmin.dao.StationMapper;
import com.qifa.pileadmin.entity.User;
import com.qifa.pileadmin.service.StationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 电站表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements StationService {
    @Resource
    private StationMapper stationMapper;

    @Resource
    private PileMapper pileMapper;

    @Override
    public Page pageAll(StationConditionDTO stationConditionDTO) {
        Page page = new Page<>(stationConditionDTO.getPageNum(),stationConditionDTO.getPageSize());
        QueryWrapper<Station> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Station> lambdaQueryWrapper = queryWrapper.lambda();
        if(stationConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Station::getId,stationConditionDTO.getId());
        }
        if(stationConditionDTO.getManagerId() != null){
            lambdaQueryWrapper.like(Station::getManagerId,stationConditionDTO.getManagerId());
        }
        if(!StrUtil.isBlank(stationConditionDTO.getName())){
            lambdaQueryWrapper.like(Station::getName,stationConditionDTO.getName());
        }
        if(!StrUtil.isBlank(stationConditionDTO.getAddress())){
            lambdaQueryWrapper.like(Station::getAddress,stationConditionDTO.getAddress());
        }
        return this.page(page,lambdaQueryWrapper);
    }

    @Override
    public boolean updateWithPile(Station station) {
        QueryWrapper<Pile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("station_id",station.getId());
        List<Pile> piles = pileMapper.selectList(queryWrapper);
        if(station.getStatus() == 1){
            for (Pile pile : piles) {
                pile.setStatus(1);
                pileMapper.updateById(pile);
            }
            stationMapper.updateById(station);
            return true;
        }
        if(station.getStatus() == 2 || station.getStatus() == 3){
            for (Pile pile : piles) {
                pile.setStatus(4);
                pileMapper.updateById(pile);
            }
            stationMapper.updateById(station);
            return true;
        }
        return false;
    }
}
