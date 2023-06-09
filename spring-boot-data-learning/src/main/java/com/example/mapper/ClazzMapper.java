package com.example.mapper;

import com.example.domain.Clazz;

/***
 * @description:
 * @author: yk
 **/
public interface ClazzMapper {
    Clazz selectOneToMany(Integer clazzId);
}
