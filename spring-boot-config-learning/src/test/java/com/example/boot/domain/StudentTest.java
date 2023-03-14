package com.example.boot.domain;

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
class StudentTest {
    @Autowired
    private Student student;

    @Test
    void testStudent(){
        System.out.println(student);
    }
}