package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@Controller
public class LoginController {
    @PostMapping("login")
    public ModelAndView login(String username, String password) {
        ModelAndView view = new ModelAndView("result");
        System.out.println(username);
        System.out.println(password);
        //trim() 方法用于删除字符串的头尾空白符。
        if (!"".equals(username.trim()) && !"".equals(password.trim())) {
            view.addObject("code", 0);
            view.addObject("username", username);
            view.addObject("password", password);
            view.addObject("msg", "登录成功");
        } else {
            view.addObject("code", 1);
            view.addObject("msg", "登录失败");
        }
        return view;
    }
}
