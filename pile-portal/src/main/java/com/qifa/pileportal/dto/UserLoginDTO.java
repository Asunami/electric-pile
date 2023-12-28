package com.qifa.pileportal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserLoginDTO {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String avatar;
    private Integer status;
    private String token;
}
