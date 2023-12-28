package com.qifa.pileportal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pileportal.dao.UserMapper;
import com.qifa.pileportal.entity.Recharge;
import com.qifa.pileportal.dao.RechargeMapper;
import com.qifa.pileportal.entity.User;
import com.qifa.pileportal.service.RechargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 充值记录表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Service
public class RechargeServiceImpl extends ServiceImpl<RechargeMapper, Recharge> implements RechargeService {

    @Resource
    private RechargeMapper rechargeMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean pay(Recharge recharge) {
        recharge.setStatus(2);
        recharge.setChargeTime(new Date());
        recharge.setAlipayId(String.valueOf(System.currentTimeMillis()/1000));
        rechargeMapper.updateById(recharge);
        User user = userMapper.selectById(recharge.getUserId());
        user.setBalance(user.getBalance().add(recharge.getMoney()));
        userMapper.updateById(user);
        return false;
    }
}
