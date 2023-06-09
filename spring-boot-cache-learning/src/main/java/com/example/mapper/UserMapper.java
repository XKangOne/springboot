package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/***
 * @description:
 * @author: yk
 **/
@Mapper
public interface UserMapper {
    @Select("select * from tb_user where id = #{value}")
    User get(Integer id);

    @Select("select * FROM tb_user ")
    List<User> findAll();

    @Select("SELECT * FROM tb_user WHERE name LIKE concat('%', #{name}, '%')")
    List<User> findAllByNameLike(@Param("name") String name);

    @Update("UPDATE tb_user SET name = #{name} WHERE id = #{id}")
    void updateById(User user);
}
