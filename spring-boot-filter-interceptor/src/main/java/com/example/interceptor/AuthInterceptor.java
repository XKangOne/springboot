package com.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是{}",requestURI);
       //在请求处理之前进行权限校验
        String token = request.getHeader("Authorization");
        if (token != null){
            if ("Admin123".equals(token)){
                //权限校验通过，放行请求
                return true;
            }else {
            //token 错误，校验失败，返回401错误码
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        }else {
//            request.setAttribute("msg","请重新登录");
//            request.getRequestDispatcher("/").forward(request,response);
            //token为空,返回401错误码
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
//        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);
    }
}
