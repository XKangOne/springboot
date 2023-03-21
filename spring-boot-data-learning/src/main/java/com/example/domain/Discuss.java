package com.example.domain;

import jakarta.persistence.*;
import lombok.Data;

/***
 * @description:
 * @author: yk
 **/
@Entity(name="t_comment")
@Data
public class Discuss {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String author;
   private  String content;

   @Column(name = "a_id")
   private Integer AId;
}
