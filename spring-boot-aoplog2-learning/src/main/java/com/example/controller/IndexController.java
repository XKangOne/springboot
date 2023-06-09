package com.example.controller;

import com.example.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * @description:
 * @author: yk
 **/
@Controller
public class IndexController {
    @Log("日志注解，配合WebAspect记录请求前、请求后、请求过程")
    @RequestMapping("/log")
    @ResponseBody
    public String log(String name){
        return "log";
    }
}