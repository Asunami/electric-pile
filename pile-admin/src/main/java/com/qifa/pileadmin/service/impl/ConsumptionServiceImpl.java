package com.qifa.pileadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.ConsumptionConditionDTO;
import com.qifa.pileadmin.entity.Consumption;
import com.qifa.pileadmin.dao.ConsumptionMapper;
import com.qifa.pileadmin.entity.Recharge;
import com.qifa.pileadmin.service.ConsumptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费记录表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class ConsumptionServiceImpl extends ServiceImpl<ConsumptionMapper, Consumption> implements ConsumptionService {

    @Override
    public Page pageAll(ConsumptionConditionDTO consumptionConditionDTO) {
        Page page = new Page<>(consumptionConditionDTO.getPageNum(),consumptionConditionDTO.getPageSize());
        QueryWrapper<Consumption> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Consumption> lambdaQueryWrapper = queryWrapper.lambda();
        if(consumptionConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Consumption::getId,consumptionConditionDTO.getId());
        }
        if (consumptionConditionDTO.getUserId() != null){
            lambdaQueryWrapper.eq(Consumption::getUserId,consumptionConditionDTO.getUserId());
        }
        if (consumptionConditionDTO.getOrderId() != null){
            lambdaQueryWrapper.eq(Consumption::getOrderId,consumptionConditionDTO.getOrderId());
        }
        return this.page(page,lambdaQueryWrapper);
    }
}
