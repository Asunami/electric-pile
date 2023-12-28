package com.qifa.pileportal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationResDTO {
    private Integer id;
    private Integer userId;
    private Integer pileId;
    private String name;
    private Integer status;
    private Date startTime;
    private Date overTime;
    private Date creatTime;
}
