package com.qifa.pileportal.dto;

import lombok.Data;

@Data
public class StationReqConditionDTO {
    private Integer id;
    private String name;
    private String address;
    private Integer sort;
    private Double longitude;
    private Double latitude;
    private Integer pageNum;
    private Integer pageSize;
}
