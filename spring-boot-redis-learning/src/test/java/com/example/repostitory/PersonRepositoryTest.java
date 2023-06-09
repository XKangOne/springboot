package com.example.repostitory;

import com.example.domain.Address;
import com.example.domain.Family;
import com.example.domain.Person;
import jakarta.annotation.Resource;
import org.hibernate.dialect.lock.PessimisticEntityLockException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 **/
@SpringBootTest
class PersonRepositoryTest {
    @Resource
    private PersonRepository personRepository;

    @Test
    public void savePerson(){
        Person person = Person.builder().firstname("张").lastname("小米").build();
        Person person2 = Person.builder().firstname("James").lastname("Harden").build();

        //创建并添加住址信息
        Address address = new Address("南京", "China");
        person.setAddress(address);

        //创建并添加家庭成员
        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲", "张三");
        Family mom = new Family("母亲", "李红");
        list.add(dad);
        list.add(mom);
        person.setFamilyList(list);

        //向Redis数据库添加数据
        Person save = personRepository.save(person);
        Person save2 = personRepository.save(person2);
        System.out.println(save);
        System.out.println(save2);
    }
    @Test
    public void selectPerson(){
        List<Person> list = personRepository.findByAddressCity("南京");
        System.out.println(list);
    }

    @Test
    public void updatePerson(){
        Person person = personRepository.findByFirstnameAndLastname("张", "小米").get(0);
        person.setLastname("小米");
        Person update = personRepository.save(person);
        System.out.println(update);
    }
    @Test
    public void deletePerson(){
        Person person = personRepository.findByFirstnameAndLastname("张", "小米").get(0);
        personRepository.delete(person);
    }
}