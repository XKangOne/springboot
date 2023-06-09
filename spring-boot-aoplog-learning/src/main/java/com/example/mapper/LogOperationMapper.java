package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.LogOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/***
 * @description:
 * @author: yk
 **/
@Repository
@Mapper
public interface LogOperationMapper extends BaseMapper<LogOperation> {
}
