package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/***
 * @WebFilter 是 Servlet3.0新增的注解，原先实现过滤器，
 * 需要在web.xml中进行配置，而现在通过此注解，启动启动时会自动扫描自动注册。
 *
 * 然后在启动类加入@ServletComponentScan注解即可。
 * 使用这种方法当注册多个过滤器时，无法指定过滤器的先后执行顺序。
 * 原本使用web.xml配置过滤器时，是可指定执行顺序的，但使用@WebFilter时，
 * 没有这个配置属性的(需要配合@Order进行)，所以接下来介绍下通过FilterRegistrationBean进行过滤器的注册。
 **/
@Slf4j
//注册器名称为customFilter,拦截的url为所有
@WebFilter(filterName="customFilter",urlPatterns={"/*"})
public class CustomFilter implements Filter {

    //启动主类就会弹出
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    //访问地址会有该代码弹出
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        log.info("CustomFilter 之前执行的逻辑");
//        filterChain.doFilter(servletRequest,servletResponse);
//        log.info("CustomFilter 之后，处理相应");

        System.out.println("过滤链1请求拦截");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器1请求放行");
    }

    //启动类关闭就会执行这个代码
    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}