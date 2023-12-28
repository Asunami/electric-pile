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
 * 预约表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("reservation")
@ApiModel(value="Reservation对象", description="预约表")
public class Reservation implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "预约编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "充电桩编号")
    private Integer pileId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "预约开始时间")
    private Date startTime;

    @ApiModelProperty(value = "预约结束时间")
    private Date overTime;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @TableLogic
    private Boolean isDelete;


}
