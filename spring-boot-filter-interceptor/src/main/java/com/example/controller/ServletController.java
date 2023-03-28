package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
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
