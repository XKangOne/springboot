package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/****
            指标监控
 https://docs.spring.io/spring-boot/docs/3.0.5/reference/html/actuator.html#actuator.endpoints

 https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.metrics.registering-custom
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}