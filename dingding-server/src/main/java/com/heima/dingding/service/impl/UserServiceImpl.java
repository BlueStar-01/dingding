package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.dto.UserLoginDTO;
import com.heima.dingdign.pojo.entity.User;
import com.heima.dingdign.pojo.vo.UserLoginVO;
import com.heima.dingding.constant.JwtClaimsConstant;
import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.exception.AccountNotFoundException;
import com.heima.dingding.exception.PasswordErrorException;
import com.heima.dingding.mapper.UserMapper;
import com.heima.dingding.properties.JwtTokenProperty;
import com.heima.dingding.service.IUserService;
import com.heima.dingding.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    private final JwtTokenProperty jwtTokenProperty;

    /**
     * 用户名密码登录
     *
     * @param loginDTO
     * @return
     */
    @Transactional
    @Override
    public UserLoginVO login(UserLoginDTO loginDTO) {
        //log.info("登录信息：{}",loginDTO);
        //获得数据
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        //先查询用户
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda()
                .eq(User::getUsername, username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //验证密码
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!user.getPassword().equals(password)) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //生成token
        return getUserLoginVO(user);
    }

    private UserLoginVO getUserLoginVO(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        claims.put(JwtClaimsConstant.USERNAME, user.getUsername());
        String token = JwtUtil.createJWT(jwtTokenProperty.getUserSecretKry(), jwtTokenProperty.getUserTTL(), claims);

        UserLoginVO loginVO = UserLoginVO.builder()
                .userId(user.getId())
                .token(token).build();

        return loginVO;
    }

    /**
     * 注册
     *
     * @param loginDTO
     * @return
     */
    @Transactional
    @Override
    public UserLoginVO register(UserLoginDTO loginDTO) {
        log.info("注册信息：{}", loginDTO);
        //先查询用户
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda()
                .eq(User::getUsername, loginDTO.getUsername());
        Long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new PasswordErrorException(MessageConstant.ACCOUNT_ALREADY_EXISTS);
        }

        //添加进数据库
        User user = User.builder()
                .username(loginDTO.getUsername())
                .password(DigestUtils.md5DigestAsHex(loginDTO.getPassword().getBytes()))
                .build();
        log.info("user:{}", user);
        userMapper.insert(user);

        //生成token
        return getUserLoginVO(user);
    }
}
