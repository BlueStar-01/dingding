package com.heima.dingding.configes;

import com.heima.dingding.interceptor.JwtTokenUserInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtTokenUserInterceptor jwtTokenUserInterceptor;

    //  TODO 如果有需要的跨域
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // 允许所有路径的跨域请求
//                .allowedOrigins("http://localhost:5173") // 允许的源
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
//                .allowedHeaders("*") // 允许的请求头
//                .allowCredentials(true); // 是否允许携带凭证
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 对所有接口路径应用跨域配置
                .allowedOrigins("http://localhost:8081") // 允许的前端域名或IP及端口
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头，这里设置为全部允许，实际可按需细化
                .allowCredentials(true) // 是否允许携带凭证（如Cookie等），如果需要传递Cookie，这里要设为true
                .maxAge(3600); // 预检请求的缓存时间，单位为秒
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        log.info("注册管理端拦截器...");
//        registry.addInterceptor(jwtTokenAdminInterceptor)
//                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin/employee/login");
        log.info("注册用户端拦截器...");
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/**")
                //用户信息请求
                //登录和注册
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                //分页搜索添加
                .excludePathPatterns("/book/page");
    }
}
