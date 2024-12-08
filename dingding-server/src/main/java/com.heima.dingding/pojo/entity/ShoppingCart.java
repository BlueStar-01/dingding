package com.heima.dingding.pojo.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
/**
* 购物车表
* @TableName shopping_cart
*/
public class ShoppingCart implements Serializable {

    /**
    * 购物车id
    */
    @NotNull(message="[购物车id]不能为空")
    private Long id;
    /**
    * 关联的用户id
    */
    @NotNull(message="[关联的用户id]不能为空")
    private Long userId;
    /**
    * 
    */
    private Date createTime;
    /**
    * 
    */
    private Date updateTime;

    /**
    * 购物车id
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 关联的用户id
    */
    private void setUserId(Long userId){
    this.userId = userId;
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
    * 购物车id
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 关联的用户id
    */
    private Long getUserId(){
    return this.userId;
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
