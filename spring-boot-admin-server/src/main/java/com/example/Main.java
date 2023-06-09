package com.example;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/***
            监控可视化组件
 https://github.com/codecentric/spring-boot-admin

 https://docs.spring-boot-admin.com/current/
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableAdminServer
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}