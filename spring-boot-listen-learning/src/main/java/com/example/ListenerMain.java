package com.example;

import com.example.event.MyEvent;
import com.example.listen.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/***
 自定义事件监听器
 SpringBoot 进行事件监听有四种方式
 1.写代码向ApplicationContext中添加监听器
 2.使用Component注解将监听器装载入spring容器
 3.在application.properties中配置监听器
 4.通过@EventListener注解实现事件监听
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ListenerMain {
    public static void main(String[] args) {
        //获取ConfigurableApplicationContext上下文
        ConfigurableApplicationContext context =  SpringApplication.run(ListenerMain.class, args);
        //装载监听
        context.addApplicationListener(new MyListener1());
        //发布事件
        context.publishEvent(new MyEvent("测试事件"));
    }
}