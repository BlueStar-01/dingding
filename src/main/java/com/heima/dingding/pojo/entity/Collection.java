package com.heima.dingding.pojo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* 收藏夹表
* @TableName collection
*/
@Data
public class Collection implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 用户id
    */
    @NotNull(message="[用户id]不能为空")
    @ApiModelProperty("用户id")
    private Long userId;
    /**
    * 收藏夹名
    */
    @NotBlank(message="[收藏夹名]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("收藏夹名")
    @Length(max= 20,message="编码长度不能超过20")
    private String name;
    /**
    * 收藏夹描述
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("收藏夹描述")
    @Length(max= 500,message="编码长度不能超过500")
    private String description;
    /**
    * 封面图片
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("封面图片")
    @Length(max= 500,message="编码长度不能超过500")
    private String coverImg;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date createTime;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date updateTime;
}
