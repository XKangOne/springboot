package com.example.config;

import com.example.interceptor.CustomHandlerInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * @description: 注册拦截器,废弃：public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter
 * @author: yk
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    private final String[] excludePath = {"/static"};

    @Resource
    private CustomHandlerInterceptor customHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器 拦截规则
        //多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}