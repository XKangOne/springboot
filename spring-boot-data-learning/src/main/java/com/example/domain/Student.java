package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Internal;

import java.time.LocalDate;
import java.util.List;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer studentId;
    private Integer clazzId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
    //在多方中声明一方的对象
    private Clazz clazz;

    private List<Course> course;

}
