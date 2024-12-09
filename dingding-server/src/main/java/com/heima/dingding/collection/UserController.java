package com.heima.dingding.collection;

import com.heima.dingdign.pojo.dto.UserLoginDTO;
import com.heima.dingdign.pojo.vo.UserLoginVO;
import com.heima.dingding.result.Result;
import com.heima.dingding.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final IUserService userService;
    /**
     * 登录请求
     *
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO loginDTO) {
        UserLoginVO userLoginVO = userService.login(loginDTO);
        log.info("登录成功{}", userLoginVO);
        return Result.success(userLoginVO);
    }
    /**
     * 注册
     *
     * @param loginDTO
     * @return
     */
    @PostMapping("/register")
    public Result<UserLoginVO> register(@RequestBody UserLoginDTO loginDTO) {
        UserLoginVO userLoginVO = userService.register(loginDTO);
        log.info("注册成功{}", userLoginVO);
        return Result.success(userLoginVO);
    }
}
