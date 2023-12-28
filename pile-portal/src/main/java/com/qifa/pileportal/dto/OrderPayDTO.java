package com.qifa.pileportal.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderPayDTO {
    private Integer reservationId;
    private Integer userId;
    private Integer pileId;
    private Integer status;
    private BigDecimal money;
    private Date startTime;
    private Date overTime;
    private Date creatTime;
    private Date modifyTime;
}
