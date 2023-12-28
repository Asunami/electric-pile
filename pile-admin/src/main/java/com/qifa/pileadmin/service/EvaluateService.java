package com.qifa.pileadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qifa.pileadmin.dto.EvaluateConditionDTO;
import com.qifa.pileadmin.entity.Evaluate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评价表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
public interface EvaluateService extends IService<Evaluate> {

    Page pageAll(EvaluateConditionDTO evaluateConditionDTO);
}
