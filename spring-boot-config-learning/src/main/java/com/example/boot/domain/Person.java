package com.example.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/***
 * @description:
 * @author: yk
 **/
//自动注入
@Component
@ConfigurationProperties(prefix = "person")
@Data
@Validated
public class Person {
    private Integer id;
    private String name;
    private String firstName;
    private List<String> hobby;
    private String[] family;
    private Map map;
    private  Pet pet;
    
}

