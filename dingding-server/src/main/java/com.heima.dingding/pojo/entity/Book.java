package com.heima.dingding.pojo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
* 书籍信息表
* @TableName book
*/
@Data
public class Book implements Serializable {

    /**
    * 书籍的唯一标识符
    */
    @NotNull(message="[书籍的唯一标识符]不能为空")
    private Long id;
    /**
    * 书籍的名称
    */
    @NotBlank(message="[书籍的名称]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @Length(max= 100,message="编码长度不能超过100")
    private String name;
    /**
    * 书籍的封面图片URL或路径
    */
    @Size(max= 500,message="编码长度不能超过500")
    @Length(max= 500,message="编码长度不能超过500")
    private String coverImg;
    /**
    * 书籍的详细描述
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @Length(max= -1,message="编码长度不能超过-1")
    private String description;
    /**
    * 书籍的国际标准书号
    */
    @NotBlank(message="[书籍的国际标准书号]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @Length(max= 20,message="编码长度不能超过20")
    private String isbn;
    /**
    * 书籍的作者
    */
    @NotBlank(message="[书籍的作者]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @Length(max= 255,message="编码长度不能超过255")
    private String author;
    /**
    * 出版社的名称
    */
    @NotBlank(message="[出版社的名称]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @Length(max= 255,message="编码长度不能超过255")
    private String publishing;
    /**
    * 书籍的出版日期
    */
    private Date publishingDate;
    /**
    * 记录创建时间
    */
    private Date createTime;
    /**
    * 记录最后更新时间
    */
    private Date updateTime;
    /**
    * 价格
    */
    @NotNull(message="[价格]不能为空")
    private Integer price;

}
