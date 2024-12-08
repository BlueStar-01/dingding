package com.itheima.dingdign.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {
    private String Username;
    private String password;
}
