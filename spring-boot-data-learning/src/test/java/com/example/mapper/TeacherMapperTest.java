package com.example.mapper;

import com.example.domain.Teacher;
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
class TeacherMapperTest {

    @Resource
    private TeacherMapper teacherMapper;
    @Test
    void selectOneByOne() {
        Teacher teacher = teacherMapper.selectOneByOne(1);
        System.out.println(teacher);
    }
}