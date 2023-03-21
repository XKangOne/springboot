package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Relevance {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
}
