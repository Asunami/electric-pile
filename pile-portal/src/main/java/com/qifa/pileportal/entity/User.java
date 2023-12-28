package com.qifa.pileportal.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 前台用户表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value="User对象", description="前台用户表")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "车辆电量")
    private Integer battery;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;


}
