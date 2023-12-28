package com.qifa.pileadmin.dto;


import com.qifa.pileadmin.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class ManagerLoginDTO {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String avatar;
    private String token;
    private String role;
    private Integer status;
    private List<Menu> menus;
}
