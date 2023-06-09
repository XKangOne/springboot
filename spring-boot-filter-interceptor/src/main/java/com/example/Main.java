package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/***
 * @description:
 * @author: yk
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ServletComponentScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}