package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/***
 * @description: RedisCacheService
 * @author: yk
 **/
@Service
@Slf4j
public class RedisCacheService {
    @Resource
    private UserMapper userMapper;

    @Cacheable(value = "getName")
    public String getName(Integer i) {
        log.info("getName invoke ......");
        return "name" + i;
    }
//    @Cacheable(value = "getUser")
//    public User getUser(Integer id) {
//        return userMapper.get(id);
//    }
    @Cacheable(value = "getUser", cacheManager = "userCacheManager")
    public User getUser(Integer id) {
        return userMapper.get(id);
    }
}