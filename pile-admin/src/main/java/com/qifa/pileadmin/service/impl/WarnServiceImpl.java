package com.qifa.pileadmin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.WarnConditionDTO;
import com.qifa.pileadmin.entity.Recharge;
import com.qifa.pileadmin.entity.Warn;
import com.qifa.pileadmin.dao.WarnMapper;
import com.qifa.pileadmin.service.WarnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 告警记录表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Service
public class WarnServiceImpl extends ServiceImpl<WarnMapper, Warn> implements WarnService {

    @Override
    public Page pageAll(WarnConditionDTO warnConditionDTO) {
        Page page = new Page<>(warnConditionDTO.getPageNum(),warnConditionDTO.getPageSize());
        QueryWrapper<Warn> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Warn> lambdaQueryWrapper = queryWrapper.lambda();
        if(warnConditionDTO.getId() != null){
            lambdaQueryWrapper.eq(Warn::getId,warnConditionDTO.getId());
        }
        if (warnConditionDTO.getPileId() != null){
            lambdaQueryWrapper.eq(Warn::getPileId,warnConditionDTO.getPileId());
        }
        if (warnConditionDTO.getStatus() != null){
            lambdaQueryWrapper.eq(Warn::getStatus,warnConditionDTO.getStatus());
        }
        if (warnConditionDTO.getWarnType() != null){
            lambdaQueryWrapper.eq(Warn::getWarnType,warnConditionDTO.getWarnType());
        }
        if(!StrUtil.isBlank(warnConditionDTO.getDetail())){
            lambdaQueryWrapper.like(Warn::getDetail,warnConditionDTO.getDetail());
        }
        return this.page(page,queryWrapper);
    }
}
