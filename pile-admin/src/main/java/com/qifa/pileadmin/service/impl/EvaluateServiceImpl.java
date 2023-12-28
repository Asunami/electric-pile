package com.qifa.pileadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.EvaluateConditionDTO;
import com.qifa.pileadmin.entity.Consumption;
import com.qifa.pileadmin.entity.Evaluate;
import com.qifa.pileadmin.dao.EvaluateMapper;
import com.qifa.pileadmin.service.EvaluateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评价表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements EvaluateService {

    @Override
    public Page pageAll(EvaluateConditionDTO evaluateConditionDTO) {
        Page page = new Page<>(evaluateConditionDTO.getPageNum(),evaluateConditionDTO.getPageSize());
        QueryWrapper<Evaluate> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Evaluate> lambdaQueryWrapper = queryWrapper.lambda();
        if(evaluateConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Evaluate::getId,evaluateConditionDTO.getId());
        }
        if (evaluateConditionDTO.getUserId() != null){
            lambdaQueryWrapper.eq(Evaluate::getUserId,evaluateConditionDTO.getUserId());
        }
        if (evaluateConditionDTO.getOrderId() != null){
            lambdaQueryWrapper.eq(Evaluate::getOrderId,evaluateConditionDTO.getOrderId());
        }
        if (evaluateConditionDTO.getStationId() != null){
            lambdaQueryWrapper.eq(Evaluate::getStationId,evaluateConditionDTO.getStationId());
        }
        if (evaluateConditionDTO.getPileId() != null){
            lambdaQueryWrapper.eq(Evaluate::getPileId,evaluateConditionDTO.getPileId());
        }
        if (evaluateConditionDTO.getGenre() != null){
            lambdaQueryWrapper.eq(Evaluate::getGenre,evaluateConditionDTO.getGenre());
        }
        return this.page(page,lambdaQueryWrapper);
    }
}
