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
 * 消费记录表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("consumption")
@ApiModel(value="Consumption对象", description="消费记录表")
public class Consumption implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "消费记录编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "订单编号")
    private Integer orderId;

    @ApiModelProperty(value = "消费金额")
    private BigDecimal money;

    @ApiModelProperty(value = "消费时间")
    private Date spendTime;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    private Boolean isDelete;


}
