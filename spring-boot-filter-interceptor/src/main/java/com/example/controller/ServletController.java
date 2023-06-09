package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

/***
 /**
 HttpServletRequest 对象获取的4种方法
 1、直接在参数中传递
 public String hello(HttpServletRequest request)

 2、通过ServletActionContext获取

 HttpServletRequest request = ServletActionContext.getRequest();

 3、通过注解获取（Spring）

 public class Hello {
@Autowired
HttpServletRequest request; //这里可以获取到request
}

 4、RequestContextHolder获取（Spring）

 HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
 */
@RestController
@RequestMapping("api")
public class ServletController {
    @GetMapping("request")
    public void testRequest(){
        //建议用如下方式去获取servlet的请求和响应
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute("author","作者");
        request.setAttribute("author","张三");
        request.removeAttribute("author");
    }
}
