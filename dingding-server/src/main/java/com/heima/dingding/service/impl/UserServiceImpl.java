package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.dto.UserLoginDTO;
import com.heima.dingdign.pojo.entity.User;
import com.heima.dingdign.pojo.vo.UserLoginVO;
import com.heima.dingding.mapper.UserMapper;
import com.heima.dingding.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 用户名密码登录
     *
     * @param loginDTO
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginDTO loginDTO) {
        return null;
    }
}
