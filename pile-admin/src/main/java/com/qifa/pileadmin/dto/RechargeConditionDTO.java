package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class RechargeConditionDTO {
    private Integer id;
    private Integer userId;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
