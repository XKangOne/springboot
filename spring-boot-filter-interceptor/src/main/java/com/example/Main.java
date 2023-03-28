package com.example;

import com.example.event.MyEvent;
import com.example.event.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.module.Configuration;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ServletComponentScan
public class Main {
    public static void main(String[] args) {
        //获取ConfigurableApplicationContext上下文
      ConfigurableApplicationContext context =  SpringApplication.run(Main.class, args);
        //装载监听
        context.addApplicationListener(new MyListener1());
        //发布事件
        context.publishEvent(new MyEvent("测试事件"));
    }
}