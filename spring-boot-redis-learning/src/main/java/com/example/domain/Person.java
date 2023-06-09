package com.example.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

/***
 * @description:
 * @author: yk
 **/
@RedisHash("persons")  //指定操作实体类对象在Redis数据库中的存储空间
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    /**
     * 标识实体类主键
     */
    @Id
    private String id;

    /**
     * 标识对应属性在Redis数据库中生成二级索引
     */
    @Indexed
    private String firstname;

    @Indexed
    private String lastname;

    private Address address;

    private List<Family> familyList;

}
