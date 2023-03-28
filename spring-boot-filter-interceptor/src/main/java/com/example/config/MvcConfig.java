package com.example.config;

import com.example.interceptor.AuthInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
//    private final String[] excludePath = {"/static"};
    private final String[] excludePath = {"/css/**","/images/**","/api/login"};
    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(authInterceptor)
               .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
               .excludePathPatterns(excludePath); //放行的请求
    }
}
