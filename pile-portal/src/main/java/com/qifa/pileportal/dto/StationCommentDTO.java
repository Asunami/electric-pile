package com.qifa.pileportal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StationCommentDTO {
    private Integer id;
    private String nickname;
    private String avator;
    private Integer score;
    private String comment;
    private String picture;
    private Date commentTime;
}
