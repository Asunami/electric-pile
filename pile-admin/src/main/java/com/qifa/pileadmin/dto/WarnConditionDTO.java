package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class WarnConditionDTO {
    private Integer id;
    private Integer pileId;
    private Integer warnType;
    private String detail;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
