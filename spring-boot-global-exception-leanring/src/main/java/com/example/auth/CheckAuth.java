package com.example.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/***
 * @description: 自定义认证注解
 * @author: yk
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuth {
    String value();
}
