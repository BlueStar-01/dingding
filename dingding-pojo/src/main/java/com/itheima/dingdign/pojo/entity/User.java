package com.itheima.dingdign.pojo.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
* 用户表
* @TableName user
*/
public class User implements Serializable {

    /**
    * 用户ID
    */
    @NotNull(message="[用户ID]不能为空")
    private Long id;
    /**
    * 用户账号信息
    */
    @NotBlank(message="[用户账号信息]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @Length(max= 20,message="编码长度不能超过20")
    private String userName;
    /**
    * 用户密码md5加密
    */
    @NotBlank(message="[用户密码md5加密]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @Length(max= 32,message="编码长度不能超过32")
    private String password;
    /**
    * 关联qq
    */
    @Size(max= 40,message="编码长度不能超过40")
    @Length(max= 40,message="编码长度不能超过40")
    private String qqId;
    /**
    * 用户昵称
    */
    @Size(max= 20,message="编码长度不能超过20")
    @Length(max= 20,message="编码长度不能超过20")
    private String nickname;
    /**
    * 头像照片链接
    */
    @Size(max= 500,message="编码长度不能超过500")
    @Length(max= 500,message="编码长度不能超过500")
    private String avatarImg;
    /**
    * 性别（男，女）
    */
    private Object sex;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 用户ID
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 用户账号信息
    */
    private void setUserName(String userName){
    this.userName = userName;
    }

    /**
    * 用户密码md5加密
    */
    private void setPassword(String password){
    this.password = password;
    }

    /**
    * 关联qq
    */
    private void setQqId(String qqId){
    this.qqId = qqId;
    }

    /**
    * 用户昵称
    */
    private void setNickname(String nickname){
    this.nickname = nickname;
    }

    /**
    * 头像照片链接
    */
    private void setAvatarImg(String avatarImg){
    this.avatarImg = avatarImg;
    }

    /**
    * 性别（男，女）
    */
    private void setSex(Object sex){
    this.sex = sex;
    }

    /**
    * 创建时间
    */
    private void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 更新时间
    */
    private void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
    }


    /**
    * 用户ID
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 用户账号信息
    */
    private String getUserName(){
    return this.userName;
    }

    /**
    * 用户密码md5加密
    */
    private String getPassword(){
    return this.password;
    }

    /**
    * 关联qq
    */
    private String getQqId(){
    return this.qqId;
    }

    /**
    * 用户昵称
    */
    private String getNickname(){
    return this.nickname;
    }

    /**
    * 头像照片链接
    */
    private String getAvatarImg(){
    return this.avatarImg;
    }

    /**
    * 性别（男，女）
    */
    private Object getSex(){
    return this.sex;
    }

    /**
    * 创建时间
    */
    private Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 更新时间
    */
    private Date getUpdateTime(){
    return this.updateTime;
    }

}
