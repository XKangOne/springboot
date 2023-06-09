package com.example.mapper;

import com.example.domain.Student;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 **/
@SpringBootTest
class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    void selectManyToOne() {
        Student student = studentMapper.selectManyToOne(1001);
        assertEquals("钱智康",student.getStudentName());
        assertEquals(1,student.getClazz().getClazzId());
//        System.out.println(student);
    }

    @Test
    void batchInsert() {
        List<Student> students =new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = Student.builder()
                    .studentId(3000+i)
                    .clazzId(1)
                    .studentName("测试学生"+i)
                    .hometown("南京")
                    .birthday(LocalDate.of(2002,10,3)).build();
            students.add(student);
        }
        int count = studentMapper.batchInsert(students);
        System.out.println(count);
    }
    @Test
    public void batchUpdate(){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = Student.builder()
                    .studentId(3000+i)
                    .clazzId(1)
                    .studentName("新名字"+i)
                    .hometown("苏州").build();
            students.add(student);
        }
        int count = studentMapper.batchUpdate(students);
        System.out.println(count);
    }
    @Test
    void batchDelete(){
        List<Integer> idList = List.of(3000,3001,3002,3003);
        int count = studentMapper.batchDelete(idList);
        System.out.println(count);
    }
    //动态查询
    @Test
    void dynamicSelect(){
        Student student = Student.builder().hometown("州").build();
        List<Student> students = studentMapper.dynamicSelect(student);
        students.forEach(s -> {
            System.out.println(s.getClazzId() + ","+s.getStudentName()+","+s.getHometown() + ","+s.getBirthday());
        });
    }
    @Test
    void getStudent(){
        Student student = new Student();
        student.setStudentId(1001);
        List<Student> student1 = studentMapper.getStudent(student);
//        System.out.println(student1);
        //这样也可以
        student1.forEach(System.out::println);
    }

    @Test
    void finById(){
        Student student = studentMapper.finById(1002);
        System.out.println(student);
    }
    @Test
    void insert(){
        Student student = Student.builder()
                .studentId(1009)
                .clazzId(2)
                .studentName("张三")
                .hometown("宿迁")
                .birthday(LocalDate.of(2023,3,12)).build();
        int insert = studentMapper.insert(student);
        System.out.println(insert);
    }
    @Test
    void update(){
        Student student =Student.builder()
                .studentId(1009)
                .clazzId(1)
                .studentName("王二")
                .hometown("常州")
                .birthday(LocalDate.of(2022,12,2)).build();
        int update = studentMapper.update(student);
        System.out.println(update);
    }

    @Test
    void delete(){
        int deletById = studentMapper.deletById(1009);
        System.out.println(deletById);
    }
}