package com.example.boot.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/***
 * @description:
 * @author: yk
 * @Component:注解 ：把Student类的实例作为Bean注入到Spring 容器中
 **/
@Data
//可以被spring批量注入
@Component
public class Student {
    @Value("#{5*6}")
    private Integer id;
//    @Value("${person.name}")
//    private String name;
    @Value("张三")
    private String name;
}
