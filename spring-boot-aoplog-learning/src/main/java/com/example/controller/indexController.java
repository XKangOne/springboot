package com.example.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * @description:
 * @author: yk
 **/

@Controller
public class indexController {
//    @Log("sds")
    @RequestMapping("/log")
    @ResponseBody
    public String Log(String name){
        return "log";
    }
}
