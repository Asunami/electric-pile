package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class ConsumptionConditionDTO {
    private Integer id;
    private Integer userId;
    private Integer orderId;
    private Integer pageNum;
    private Integer pageSize;
}
