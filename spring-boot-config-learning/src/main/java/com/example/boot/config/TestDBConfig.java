package com.example.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/***
 * @description:
 * @author: yk
 **/
@Configuration
@Profile("dev") //指定多环境配置类标识
public class TestDBConfig implements DBConfig{
    @Override
    public String configure() {
        return "dev 环境数据库配置";
    }
}
