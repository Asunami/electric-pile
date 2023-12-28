package com.qifa.pileadmin.dto;

import lombok.Data;

@Data
public class UserConditionDTO {
    private String username;
    private String nickname;
    private String phone;
    private Integer pageNum;
    private Integer pageSize;
}
