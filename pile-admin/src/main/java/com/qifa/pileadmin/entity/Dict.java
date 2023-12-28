package com.qifa.pileadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dict")
@ApiModel(value="Dict对象", description="")
public class Dict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "图标编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "图标名")
    private String name;

    @ApiModelProperty(value = "图标在element-ui中的值")
    private String value;

    @ApiModelProperty(value = " 图标类型")
    private String type;


}
