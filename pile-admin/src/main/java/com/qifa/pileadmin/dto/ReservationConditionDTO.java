package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class ReservationConditionDTO {
    private Integer id;
    private Integer userId;
    private Integer pileId;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
