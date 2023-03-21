package com.example.mapper;

import com.example.domain.Clazz;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
public interface ClazzMapper {

    Clazz selectOneToMany(Integer clazzId);
}
