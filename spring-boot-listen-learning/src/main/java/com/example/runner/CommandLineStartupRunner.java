package com.example.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 应用启动的监听
 SpringBoot 提供了两个接口：CommandLineRunner、ApplicationRunner，用于启动应用时做特殊处理，
 这些代码会在SpringApplication的run()方法运行完成之前被执行。
 相对于之前介绍的Spring的ApplicationListener接口自定义监听器、Servlet的ServletContextListener监听器。
 使用二者的好处在于，可以方便地使用应用启动参数，根据参数不同做不同的初始化操作。

 实现 CommandLineRunner、ApplicationRunner接口，通常用于应用启动前的特殊代码执行，比如：
 ●
 将系统常用的数据加载到内存
 ●
 应用上一次运行的垃圾数据清理
 ●
 系统启动成功后的通知的发送
*/

//CommandLineRunner：参数是字符串数组
@Component
@Slf4j
public class CommandLineStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineStartupRunner传入参数：{}", Arrays.toString(args));
    }
}
