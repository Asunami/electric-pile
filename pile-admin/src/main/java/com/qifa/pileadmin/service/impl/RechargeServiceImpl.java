package com.qifa.pileadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.RechargeConditionDTO;
import com.qifa.pileadmin.entity.Order;
import com.qifa.pileadmin.entity.Recharge;
import com.qifa.pileadmin.dao.RechargeMapper;
import com.qifa.pileadmin.service.RechargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 充值记录表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class RechargeServiceImpl extends ServiceImpl<RechargeMapper, Recharge> implements RechargeService {

    @Override
    public Page pageAll(RechargeConditionDTO rechargeConditionDTO) {
        Page page = new Page<>(rechargeConditionDTO.getPageNum(),rechargeConditionDTO.getPageSize());
        QueryWrapper<Recharge> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Recharge> lambdaQueryWrapper = queryWrapper.lambda();
        if(rechargeConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Recharge::getId,rechargeConditionDTO.getId());
        }
        if (rechargeConditionDTO.getUserId() != null){
            lambdaQueryWrapper.eq(Recharge::getUserId,rechargeConditionDTO.getUserId());
        }
        if (rechargeConditionDTO.getStatus() != null){
            lambdaQueryWrapper.eq(Recharge::getStatus,rechargeConditionDTO.getStatus());
        }
        return this.page(page,lambdaQueryWrapper);
    }
}
