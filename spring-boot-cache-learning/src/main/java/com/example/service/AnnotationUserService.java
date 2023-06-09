package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/***
 * @description:
 * @author: yk
 **/
@Service
@Slf4j
public class AnnotationUserService {
    @Resource
    private UserMapper userMapper;

//    @Cacheable("user.get")
//    public User get(Integer id) {
//        return userMapper.get(id);
//    }
    @Cacheable(value = "user.get", key = "#root.methodName")
    public User get(Integer id) {
        return userMapper.get(id);
    }

    @CachePut(value = "user.get", key = "#user.id")
    public User update(User user) {
        userMapper.updateById(user);
        return user;
    }
    @CacheEvict(value = "user.get", key = "#id")
    public void deleteById(Integer id) {
        // userMapper.deleteById(id);
        log.info("deleteById invoke ......");
    }
}
