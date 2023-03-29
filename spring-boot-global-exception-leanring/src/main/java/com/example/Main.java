package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/***
 全局统一异常处理练习：
 1、封装异常类枚举类 CustomExceptionType
 2、封装异常信息接口 MsgConsts，用来维护常量
 3、定义自定义异常 CustomException，继承 RuntimeException
 4、定义接口的统一返回数据结构 AjaxResponse
 5、定义全局的异常处理器 WebExceptionHandler ，用 @ControllerAdvice 注解来对 CustomException 做全局异常处理
 6、编写业务逻辑类 ExceptionService，自定义触发规则，手动 throw 自定义异常
 7、编写测试接口 TestController ，准备数据，测试
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}