package com.example.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
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
class ClazzMapperTest {
    @Resource
    private ClazzMapper clazzMapper;
    @Test
    void selectOneToMany() {
        System.out.println(clazzMapper.selectOneToMany(2));
    }
}