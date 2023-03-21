package com.example.mapper;

import com.example.domain.Teacher;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/

public interface TeacherMapper {
    //一对一查询
    Teacher selectOneByOne(int teacherId);
}
