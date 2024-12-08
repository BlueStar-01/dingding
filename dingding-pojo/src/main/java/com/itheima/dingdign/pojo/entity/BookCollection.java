package com.itheima.dingdign.pojo.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
* 记录了收藏集里的书
* @TableName book_collection
*/
public class BookCollection implements Serializable {

    /**
    * 关联id
    */
    @NotNull(message="[关联id]不能为空")
    private Long id;
    /**
    * 书籍id
    */
    @NotNull(message="[书籍id]不能为空")
    private Long bookId;
    /**
    * 收藏夹id
    */
    @NotNull(message="[收藏夹id]不能为空")
    private Long collectionId;
    /**
    * 创建时间
    */
    private Date createId;
    /**
    * 
    */
    private Date updateId;

    /**
    * 关联id
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 书籍id
    */
    private void setBookId(Long bookId){
    this.bookId = bookId;
    }

    /**
    * 收藏夹id
    */
    private void setCollectionId(Long collectionId){
    this.collectionId = collectionId;
    }

    /**
    * 创建时间
    */
    private void setCreateId(Date createId){
    this.createId = createId;
    }

    /**
    * 
    */
    private void setUpdateId(Date updateId){
    this.updateId = updateId;
    }


    /**
    * 关联id
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 书籍id
    */
    private Long getBookId(){
    return this.bookId;
    }

    /**
    * 收藏夹id
    */
    private Long getCollectionId(){
    return this.collectionId;
    }

    /**
    * 创建时间
    */
    private Date getCreateId(){
    return this.createId;
    }

    /**
    * 
    */
    private Date getUpdateId(){
    return this.updateId;
    }

}
