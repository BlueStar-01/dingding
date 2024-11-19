package com.heima.dingding.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class BookVO {
    /**
     * 书籍的唯一标识符
     */
    @NotNull(message="[书籍的唯一标识符]不能为空")
    @ApiModelProperty("书籍的唯一标识符")
    private Long id;
    /**
     * 书籍的名称
     */
    @NotBlank(message="[书籍的名称]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("书籍的名称")
    @Length(max= 100,message="编码长度不能超过100")
    private String name;
    /**
     * 书籍的封面图片URL或路径
     */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("书籍的封面图片URL或路径")
    @Length(max= 500,message="编码长度不能超过500")
    private String coverImg;
    /**
     * 书籍的详细描述
     */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("书籍的详细描述")
    @Length(max= -1,message="编码长度不能超过-1")
    private String description;
    /**
     * 书籍的国际标准书号
     */
    @NotBlank(message="[书籍的国际标准书号]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("书籍的国际标准书号")
    @Length(max= 20,message="编码长度不能超过20")
    private String isbn;
    /**
     * 书籍的作者
     */
    @NotBlank(message="[书籍的作者]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("书籍的作者")
    @Length(max= 255,message="编码长度不能超过255")
    private String author;
    /**
     * 出版社的名称
     */
    @NotBlank(message="[出版社的名称]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("出版社的名称")
    @Length(max= 255,message="编码长度不能超过255")
    private String publishing;
    /**
     * 书籍的出版日期
     */
    @ApiModelProperty("书籍的出版日期")
    private Date publishingDate;
    /**
     * 价格
     */
    @NotNull(message="[价格]不能为空")
    @ApiModelProperty("价格")
    private Integer price;
}
