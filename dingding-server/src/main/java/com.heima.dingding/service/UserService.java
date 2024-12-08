package com.heima.dingding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.dingding.pojo.dto.UserLoginDTO;
import com.heima.dingding.pojo.entity.User;
import com.heima.dingding.pojo.vo.UserLoginVO;

/**
* @author 碧蓝小新星
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-11-19 22:36:41
*/
public interface UserService extends IService<User> {

    /**
     * @param loginDTO
     * @return
     */
    UserLoginVO login(UserLoginDTO loginDTO);
}