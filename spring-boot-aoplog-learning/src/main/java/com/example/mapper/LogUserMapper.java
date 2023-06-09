package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.LogUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/***
 * @description:
 * @author: yk
 **/
@Repository
public interface LogUserMapper extends BaseMapper<LogUser> {
}
