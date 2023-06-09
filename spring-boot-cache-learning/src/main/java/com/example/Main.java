package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/***
    要在启动类上标注 @EnableCaching 注解，表示我们需要开启缓存机制，
 * 还要加上 MyBatis 的扫包注解。
 **/
@EnableCaching
@MapperScan(basePackages = {"com.example.mapper"})
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}