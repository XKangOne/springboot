package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @description:为了实现多对多的关系，创建的学生与课程的表
 * @author: yk
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Relevance {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
}
