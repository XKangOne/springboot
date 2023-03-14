package com.example.boot.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@SpringBootTest
class MyConfigTest {
    @Autowired
    private MyConfig myConfig;
    @Test
    void myService() {
       myConfig.myService().sayHello();
    }
}