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
 * 订单表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("order_item")
@ApiModel(value="OrderItem对象", description="订单表")
public class OrderItem implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "预约记录编号")
    private Integer reservationId;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "电桩编号")
    private Integer pileId;

    @ApiModelProperty(value = "订单状态")
    private Integer status;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal money;

    @ApiModelProperty(value = "充电开始时间")
    private Date startTime;

    @ApiModelProperty(value = "充电结束时间")
    private Date overTime;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    private Boolean isDelete;


}
