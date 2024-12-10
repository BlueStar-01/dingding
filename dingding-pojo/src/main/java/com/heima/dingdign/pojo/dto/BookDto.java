package com.heima.dingdign.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookDto implements Serializable {
    @ApiModelProperty(value = "书籍的唯一标识符")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "书籍的名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "书籍的封面图片URL或路径")
    @TableField("cover_img")
    private String coverImg;

    @ApiModelProperty(value = "书籍的详细描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "书籍的作者")
    @TableField("author")
    private String author;

    @ApiModelProperty(value = "出版社的名称")
    @TableField("publishing")
    private String publishing;

    @ApiModelProperty(value = "书籍的出版日期")
    @TableField("publishing_date")
    private LocalDate publishingDate;

    @ApiModelProperty(value = "记录创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "记录最后更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "价格")
    @TableField("price")
    private Integer price;

    @ApiModelProperty(value = "书籍分类ID")
    @TableField("type_id")
    private Long typeId;

    @ApiModelProperty(value = "是否为新书（0：否，1：是）")
    @TableField("is_new")
    private Boolean isNew;

    @ApiModelProperty(value = "平均评分")
    @TableField("rating")
    private BigDecimal rating;
}
