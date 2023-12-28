package com.qifa.pileadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色-权限关联表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("role_menu")
@ApiModel(value="RoleMenu对象", description="角色-权限关联表")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "联系编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer roleId;

    private Integer menuId;


}
