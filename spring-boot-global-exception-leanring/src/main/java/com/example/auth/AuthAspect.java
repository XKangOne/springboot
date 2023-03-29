package com.example.auth;

import com.example.enums.CustomExceptionType;
import com.example.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
/***
 * @description: 认证切面
 * @author: yk
 **/
@Aspect
@Component
public class AuthAspect {
    @Around("@annotation(com.example.auth.CheckAuth)")
    public Object checkAuth(ProceedingJoinPoint point) throws Throwable{
        //获取请求头
        HttpServletRequest request = getHttpServletRequest();
        String token = request.getHeader("Authorization");
        if (token == null){
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }
        //获取注解上的value
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        CheckAuth annotation = method.getAnnotation(CheckAuth.class);
        String value = annotation.value();
        //不等，证明 token错误
        if (!value.equals(token)) {
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }
        return point.proceed();
    }
    //获取 HttpServletRequest 对象
    private HttpServletRequest getHttpServletRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        assert attributes != null;
        return attributes.getRequest();
    }
}
