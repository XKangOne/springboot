package com.example.boot.config;

import com.example.boot.prop.MyProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@SpringBootTest
class MyPropertiesTest {
    @Autowired
    private MyProperties myProperties;
    @Test
    void test(){
        System.out.println(myProperties);
    }
}