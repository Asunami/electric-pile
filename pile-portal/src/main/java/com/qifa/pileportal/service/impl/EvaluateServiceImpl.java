package com.qifa.pileportal.service.impl;

import com.qifa.pileportal.dao.OrderItemMapper;
import com.qifa.pileportal.dao.PileMapper;
import com.qifa.pileportal.entity.Evaluate;
import com.qifa.pileportal.dao.EvaluateMapper;
import com.qifa.pileportal.entity.OrderItem;
import com.qifa.pileportal.entity.Pile;
import com.qifa.pileportal.service.EvaluateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 评价表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements EvaluateService {

    @Resource
    private EvaluateMapper evaluateMapper;

    @Resource
    private PileMapper pileMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public boolean addNewEva(Evaluate evaluate) {
        Pile pile = pileMapper.selectById(evaluate.getPileId());
        evaluate.setStationId(pile.getStationId());
        evaluate.setCommentTime(new Date());
        evaluate.setCreatTime(new Date());
        evaluateMapper.insert(evaluate);

        OrderItem orderItem = orderItemMapper.selectById(evaluate.getOrderId());
        orderItem.setStatus(3);
        orderItemMapper.updateById(orderItem);

        return true;
    }
}
