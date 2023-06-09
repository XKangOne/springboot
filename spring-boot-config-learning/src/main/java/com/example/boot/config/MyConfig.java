package com.example.boot.config;

import com.example.boot.service.MyService;
import org.springframework.context.annotation.Bean;
/***
 * @description: 使用 @Configuration 编写自定义配置类
 * @author: yk
 **/
//@Configuration
public class MyConfig {
    //将该方法的返回值，作为一个Bean，添加到spring容器中,该Bean的id就是方法名
    //@return MyService 实例
    @Bean
    public MyService myService(){
        return new MyService();
    }
}
