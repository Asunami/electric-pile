package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class EvaluateConditionDTO {
    private Integer id;
    private Integer userId;
    private Integer orderId;
    private Integer stationId;
    private Integer pileId;
    private Integer genre;
    private Integer pageNum;
    private Integer pageSize;
}
