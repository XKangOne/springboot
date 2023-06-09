package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/***
 * @description: Servlet过滤器的实现
 * 过滤器的原理就是：按照顺序先后拦截，然后回来的时候按照顺序的逆序方行
 *
 * 过滤器主要的特点在于：一是可以过滤所有请求，二是它能够改变请求的数据内容，进去是1-2-3，出来就得3-2-1了
 *
 * 过滤器
 * 1.1 定义
 * Servlet 过滤器是可用于 Servlet 编程的 Java 类，目的：
 * ●
 * 在客户端的请求访问后端资源之前，拦截这些请求。
 * ●
 * 在服务器的响应发送回客户端之前，处理这些响应。
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ServletComponentScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}