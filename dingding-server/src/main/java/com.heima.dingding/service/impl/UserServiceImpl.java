package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingding.mapper.UserMapper;
import com.heima.dingding.pojo.dto.UserLoginDTO;
import com.heima.dingding.pojo.entity.User;
import com.heima.dingding.pojo.vo.UserLoginVO;
import com.heima.dingding.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author 碧蓝小新星
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-11-19 22:36:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    /**
     * 登录生成token
     * @param loginDTO
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();



        return null;
    }
}




