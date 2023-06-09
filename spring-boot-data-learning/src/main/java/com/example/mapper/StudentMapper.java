package com.example.mapper;

import com.example.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;


import java.util.List;

/***
 * @description:
 * @author: yk
 **/
public interface StudentMapper {
    Student selectManyToOne(Integer studentId);

    int batchInsert(@Param("students") List<Student> students);

    /**
     * @description 批量修改学生信息
     * @param: students 学生集合
     * @return
    */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * @description 批量删除学生
     * @param:idList 待删除的学生的学生id结合
    */
    int batchDelete(@Param("idList") List<Integer> idList);
    /**
     * @description 动态 SQL查询
     * @param: student 查询对象
     * @return 查询到的学生集合
    */
    List<Student> dynamicSelect(Student student);

    List<Student> getStudent(Student student);

    /**
     * @description 使用注解的开发方式
    */
    /**
     * @description 根据主键查询学生信息
     * @param: studentId 学生id
     * @return 学生对象
    */
    @Select("SELECT * FROM t_student WHERE student_id = #{studentId}")
    Student finById(int studentId);

    /**
     * @description 新增学生
     * @param: student 学生对象
     * @return
    */
    @Insert("INSERT INTO t_student(student_id,clazz_id,student_name,hometown,birthday) VALUES (#{studentId},#{clazzId},#{studentName},#{hometown},#{birthday})")
    int insert(Student student);
    /**
     * @description 修改学生信息
     * @param: student 待修改学生的对象
    */
    @Update("UPDATE t_student SET clazz_id=#{clazzId},student_name=#{studentName},hometown=#{hometown},birthday=#{birthday} WHERE student_id=#{studentId}")
    int update(Student student);
    /**
     * @description 根据id删除学生
     * @param:student 学生id
    */
    @Delete("DELETE FROM t_student WHERE student_id = #{studentId}")
    int deletById(int studentId);
}
