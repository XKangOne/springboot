package com.example.repository;

import com.example.domain.Article;
import com.example.domain.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @description:
 * @author: yk
 **/
public interface ArticleRepository extends JpaRepository<Article,Integer> {
}