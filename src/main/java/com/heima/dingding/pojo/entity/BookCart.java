package com.heima.dingding.pojo.entity;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;

/**
* 购物内容表
* @TableName book_cart
*/
public class BookCart implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    private Long id;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    private Long bookId;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    private Long cartId;
    /**
    * 记录书的数量
    */
    @NotNull(message="[记录书的数量]不能为空")
    private Integer number;
    /**
    * 
    */
    private Date createTime;
    /**
    * 
    */
    private Date updateTime;

    /**
    * 
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 
    */
    private void setBookId(Long bookId){
    this.bookId = bookId;
    }

    /**
    * 
    */
    private void setCartId(Long cartId){
    this.cartId = cartId;
    }

    /**
    * 记录书的数量
    */
    private void setNumber(Integer number){
    this.number = number;
    }

    /**
    * 
    */
    private void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 
    */
    private void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
    }


    /**
    * 
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 
    */
    private Long getBookId(){
    return this.bookId;
    }

    /**
    * 
    */
    private Long getCartId(){
    return this.cartId;
    }

    /**
    * 记录书的数量
    */
    private Integer getNumber(){
    return this.number;
    }

    /**
    * 
    */
    private Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 
    */
    private Date getUpdateTime(){
    return this.updateTime;
    }

}
