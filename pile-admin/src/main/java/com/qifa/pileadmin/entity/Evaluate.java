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
 * 评价表
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("evaluate")
@ApiModel(value="Evaluate对象", description="评价表")
public class Evaluate implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "评价编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "电站编号")
    private Integer stationId;

    @ApiModelProperty(value = "电桩编号")
    private Integer pileId;

    @ApiModelProperty(value = "电桩编号")
    private Integer orderId;

    @ApiModelProperty(value = "评论类型")
    private Integer genre;

    @ApiModelProperty(value = "评分")
    private Integer score;

    @ApiModelProperty(value = "评论")
    private String comment;

    @ApiModelProperty(value = "图片")
    private String picture;

    @ApiModelProperty(value = "评价时间")
    private Date commentTime;

    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @TableLogic
    private Boolean isDelete;
}
