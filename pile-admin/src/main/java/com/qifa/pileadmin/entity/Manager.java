package com.qifa.pileadmin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台管理员表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manager")
@ApiModel(value="Manager对象", description="后台管理员表")
public class Manager implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "管理员编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实名字")
    private String realname;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "申请信息")
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @TableLogic
    private Boolean isDelete;


}
