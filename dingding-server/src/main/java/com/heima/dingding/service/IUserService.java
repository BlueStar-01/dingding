package com.heima.dingding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.dingdign.pojo.dto.UserLoginDTO;
import com.heima.dingdign.pojo.entity.User;
import com.heima.dingdign.pojo.vo.UserLoginVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
public interface IUserService extends IService<User> {

    UserLoginVO login(UserLoginDTO loginDTO);
}
