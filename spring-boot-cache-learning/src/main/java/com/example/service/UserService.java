package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @description:
 * @author: yk
 **/
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User get(Integer id){
        return userMapper.get(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findAllByNameLike(String name){
        return userMapper.findAllByNameLike(name);
    }
}
