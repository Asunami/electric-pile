package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class StationConditionDTO {
    private Integer id;
    private Integer managerId;
    private String name;
    private String address;
    private Integer pageNum;
    private Integer pageSize;
}
