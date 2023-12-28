package com.qifa.pileadmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * rbac菜单表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("menu")
@ApiModel(value="Menu对象", description="rbac菜单表")
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "菜单编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父级菜单id")
    private Integer pid;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "访问路劲")
    private String path;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "菜单描述")
    private String description;

    @ApiModelProperty(value = "页面路径")
    private String pagePath;

    @ApiModelProperty(value = "排序权重")
    private Integer sort;

    @TableField(exist = false)
    private List<Menu> children;

}
