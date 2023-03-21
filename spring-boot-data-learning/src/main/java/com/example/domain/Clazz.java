package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    //一方中声明多方的集合
    private List<Student> students;
}
