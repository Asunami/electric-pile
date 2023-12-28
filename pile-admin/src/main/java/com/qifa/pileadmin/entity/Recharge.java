package com.qifa.pileadmin.entity;

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
 * 充值记录表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("recharge")
@ApiModel(value="Recharge对象", description="充值记录表")
public class Recharge implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "充值编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "支付宝订单号")
    private String alipayId;

    @ApiModelProperty(value = "充值金额")
    private BigDecimal money;

    @ApiModelProperty(value = "充值方式")
    private Integer status;

    @ApiModelProperty(value = "充值时间")
    private Date chargeTime;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @TableLogic
    private Boolean isDelete;


}
