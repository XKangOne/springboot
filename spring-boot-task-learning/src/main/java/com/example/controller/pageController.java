package com.example.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.example.Main;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/***
 * @description: 使用hutool工具 做出不断刷新变化的二维码
 * https://www.hutool.cn/docs/#/
 * @author: yk
 **/

@Controller
public class pageController {

    //    @GetMapping("index")
//    public String getIndex(){
//        return "index";
//    }
    @GetMapping("get")
    public void getErwema(HttpServletRequest request, HttpServletResponse response) throws IOException {
        QrConfig config = new QrConfig(300, 300);
        config.setMargin((int) Math.random() * 100);

        //System.currentTimeMillis()产生一个当前的毫秒
        //String.valueOf()方法的功能: 返回参数对象的字符串表示法
        String timeMills = String.valueOf(System.currentTimeMillis());

        File file = QrCodeUtil.generate(timeMills, config, FileUtil.file("E:\\IDEA\\spring-boot-learning\\spring-boot-task-learning\\src\\main\\resources\\static\\image\\qrcode.jpg"));

        //设置响应给客户端的文件格式
        response.setContentType("image/png");

        //使用OutputStream字节流进行数据的输出
        response.getOutputStream().write(FileUtil.readBytes(file));

        // response.setIntHeader("refresh",1);
        //进行刷新
        response.getOutputStream().flush();
        //关闭
        response.getOutputStream().close();
    }
}
