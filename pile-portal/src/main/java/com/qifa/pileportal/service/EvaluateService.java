package com.qifa.pileportal.service;

import com.qifa.pileportal.entity.Evaluate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评价表 服务类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
public interface EvaluateService extends IService<Evaluate> {

    boolean addNewEva(Evaluate evaluate);
}
