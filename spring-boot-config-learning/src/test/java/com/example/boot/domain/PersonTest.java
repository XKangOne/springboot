package com.example.boot.domain;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 **/
@SpringBootTest
public class PersonTest {
    @Autowired
    private Person person;
    @Test
    void testPerson(){
        System.out.println(person);
    }
}