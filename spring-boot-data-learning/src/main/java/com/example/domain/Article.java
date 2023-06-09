package com.example.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@Data
@Entity(name = "t_article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    //@Column 用来标识实体类中属性与数据表中字段的对应关系
    @Column(name = "cover")
    private String cover;
    //实现一对多的关系
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "a_id")
    private List<Discuss> discussList;
}
