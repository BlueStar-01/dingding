package com.heima.dingdign.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookPageDto {
    @ApiModelProperty(value = "分页页数")
    private Integer pageNo;

    @ApiModelProperty(value = "分页查询尺寸")
    private Integer pageSize;

    @ApiModelProperty(value = "书名关键词匹配")
    private String name;

    @ApiModelProperty(value = "作者匹配")
    private String author;

    @ApiModelProperty(value = "创建开始时间")
    private LocalDateTime createStartTime;

    @ApiModelProperty(value = "创建结束时间")
    private LocalDateTime createEndTime;

    @ApiModelProperty(value = "更新开始时间")
    private LocalDateTime updateStartTime;

    @ApiModelProperty(value = "创建结束时间")
    private LocalDateTime updateEndTime;

    @ApiModelProperty(value = "最小价格")
    private Integer minPrice;

    @ApiModelProperty(value = "最大价格")
    private Integer maxPrice;

    @ApiModelProperty(value = "书籍分类")
    private Long typeId;


}
