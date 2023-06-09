package com.example.service;

import com.example.entity.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 **/
@SpringBootTest
@Slf4j
class CachedUserServiceTest {
    @Resource
    private UserService userService;

    @Resource
    private CachedUserService cachedUserService;

    /**
     test1 方法用来测试不带缓存的 UserService
    */
    @Test
    public void test1() {
        User user1 = userService.get(1);
        User user2 = userService.get(1);
        log.info(String.valueOf(user1 == user2));
    }

    /***
     test2 方法则是测试带缓存的 CachedUserService
    */
    @Test
    public void test2() {
        User user1 = cachedUserService.get(1);
        User user2 = cachedUserService.get(1);
        log.info(String.valueOf(user1 == user2));
    }
    @Test
    public void test3() {
        List<User> users1 = cachedUserService.findAll();
        List<User> users2 = cachedUserService.findAll();
        log.info(String.valueOf(users1 == users2));
    }

    @Test
    public void test4() {
        List<User> users1 = cachedUserService.findAllByNameLike("张");
        List<User> users2 = cachedUserService.findAllByNameLike("张");
        log.info(String.valueOf(users1 == users2));
    }
}