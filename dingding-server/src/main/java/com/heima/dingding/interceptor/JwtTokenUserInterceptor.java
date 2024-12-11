package com.heima.dingding.interceptor;

import com.heima.dingding.constant.JwtClaimsConstant;
import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.context.BaseContext;
import com.heima.dingding.properties.JwtTokenProperty;
import com.heima.dingding.result.Result;
import com.heima.dingding.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class JwtTokenUserInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenProperty jwtTokenProperty;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        try {
            //获得token
            String token = request.getHeader(jwtTokenProperty.getUserTokenName());
            //解析token（如果报错，则换回401）
            Claims claims = JwtUtil.parseJWT(jwtTokenProperty.getUserSecretKry(), token);
            //获得用户ID
            //log.info("token:{}\nclaims:{}", token, claims);
            Long userid = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            //存入当前请求的线程池中。
            BaseContext.setCurrentId(userid);
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter()
                    .print(Result.error(MessageConstant.USER_NOT_LOGIN));
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
