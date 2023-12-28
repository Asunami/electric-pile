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
 * 告警记录表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("warn")
@ApiModel(value="Warn对象", description="告警记录表")
public class Warn implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "告警记录编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "电桩编号")
    private Integer pileId;

    @ApiModelProperty(value = "告警类型")
    private Integer warnType;

    @ApiModelProperty(value = "告警内容")
    private String detail;

    @ApiModelProperty(value = "告警时间")
    private Date warnTime;

    @ApiModelProperty(value = "告警状态")
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @TableLogic
    private Boolean isDelete;

}
