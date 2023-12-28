package com.qifa.pileadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.PileConditionDTO;
import com.qifa.pileadmin.entity.Pile;
import com.qifa.pileadmin.dao.PileMapper;
import com.qifa.pileadmin.service.PileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 充电桩表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class PileServiceImpl extends ServiceImpl<PileMapper, Pile> implements PileService {

    @Override
    public Page pageAll(PileConditionDTO pileConditionDTO) {
        Page page = new Page<>(pileConditionDTO.getPageNum(),pileConditionDTO.getPageSize());
        QueryWrapper<Pile> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Pile> lambdaQueryWrapper = queryWrapper.lambda();
        if(pileConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Pile::getId,pileConditionDTO.getId());
        }
        if(pileConditionDTO.getStationId() != null){
            lambdaQueryWrapper.like(Pile::getStationId,pileConditionDTO.getStationId());
        }
        if (pileConditionDTO.getStatus() != null){
            lambdaQueryWrapper.eq(Pile::getStatus,pileConditionDTO.getStatus());
        }
        return this.page(page,lambdaQueryWrapper);
    }
}
