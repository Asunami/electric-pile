package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class PileConditionDTO {
    private Integer id;
    private Integer stationId;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
