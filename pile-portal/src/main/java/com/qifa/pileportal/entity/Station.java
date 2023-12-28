package com.qifa.pileportal.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 电站表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("station")
@ApiModel(value="Station对象", description="电站表")
public class Station implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "电站编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "管理员编号")
    private Integer managerId;

    @ApiModelProperty(value = "电站名字")
    private String name;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "图片")
    private String picture;

    @ApiModelProperty(value = "营业状态")
    private Integer status;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "距离")
    private Double distance;

    private Date creatTime;

    private Date modifyTime;

    private Boolean isDelete;

    @TableField(exist = false)
    private List<Pile> childrenPile;


}
