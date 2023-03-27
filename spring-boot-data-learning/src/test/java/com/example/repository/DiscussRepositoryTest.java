package com.example.repository;

import com.example.domain.Discuss;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@SpringBootTest
class DiscussRepositoryTest {
    @Resource
    private DiscussRepository discussRepository;

    @Test
    void findByAuthorNotNull() {
        List<Discuss> list = discussRepository.findByAuthorNotNull();
        list.forEach(System.out::println);
    }
    //使用JpaRepository 方法名关键字进行查询
    @Test
    void findByAuthor() {
        List<Discuss> list = discussRepository.findByAuthor("张三");
        list.forEach(System.out::println);
    }
    @Test
    void findByAuthorLike() {
        List<Discuss> list = discussRepository.findByAuthorLike("%张%");
        list.forEach(System.out::println);
    }

    @Test
    void findByAIdEquals(){
        List<Discuss> list= discussRepository.findByAIdEquals(1);
        list.forEach(System.out::println);
    }
/***
 * @description 使用JpaRepository 内部自带的方法测试
 * @param:
*/
    @Test
    void selectComent(){
        Optional<Discuss> optional = discussRepository.findById(1);
        //判空
        optional.ifPresent(System.out::println);

//        boolean present = optional.isPresent();
//        if (present){
//            Discuss discuss = optional.get();
//            System.out.println(discuss);
//        }
    }
    @Test
    void getDiscussesByPage(){
        Pageable pageable = PageRequest.of(1, 2);
        List<Discuss> list = discussRepository.getDiscussesByPage(pageable);
        list.forEach(System.out::println);
    }
    @Test
    void getDiscussesByPage1(){
        Pageable pageable = PageRequest.of(0, 2);
        List<Discuss> list = discussRepository.getDiscussesByPage1(1,pageable);
        list.forEach(System.out::println);
    }
    @Test
    public void selectCommentByKeys(){
        List<Discuss> list = discussRepository.findByAIdEquals(1);
        System.out.println(list);
    }
    //使用Query注解进行数据操作
    @Test
    public void selectCommentPaged(){
        Pageable pageable = PageRequest.of(0, 3);
        List<Discuss> allPaged = discussRepository.getDiscussesByPage1(1, pageable);
        System.out.println(allPaged);
    }

    //使用Example 封装参数进行数据查询操作
    @Test
    public void selectCommentByExample(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("张三");
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list = discussRepository.findAll(example);
        System.out.println(list);
    }
    @Test
    public void selectCommentByExampleMatcher(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("张");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author", startsWith());
        Example<Discuss> example = Example.of(discuss,matcher);
        List<Discuss> list = discussRepository.findAll(example);
        System.out.println(list);
    }


}

