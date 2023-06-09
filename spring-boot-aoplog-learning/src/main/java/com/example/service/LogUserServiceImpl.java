package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.LogUser;
import com.example.mapper.LogUserMapper;
import org.springframework.stereotype.Service;

/***
 * @description:
 * @author: yk
 **/
@Service
public class LogUserServiceImpl extends ServiceImpl<LogUserMapper, LogUser> implements ILogUserService {
}

