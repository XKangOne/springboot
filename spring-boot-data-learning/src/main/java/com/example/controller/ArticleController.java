package com.example.controller;

import com.example.domain.Article;
import com.example.domain.Discuss;
import com.example.repository.ArticleRepository;
import com.example.repository.DiscussRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@Controller
@AllArgsConstructor
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final DiscussRepository discussRepository;
    @GetMapping("Article")
    public String indexPage(ModelMap map){
        map.put("articleList",articleRepository.findAll());
        return "index";
    }
    @GetMapping("detail")
    public String articleDetail(@RequestParam(value = "id",required = false) Integer id,ModelMap map){
        Optional<Article> articleOptional = articleRepository.findById(id);
        Optional<Discuss> byId = discussRepository.findById(id);

//        boolean present = articleOptional.isPresent();
//        if (present){
//            Article article = articleOptional.get();
//        }
        articleOptional.ifPresent(article -> map.put("article",article));
        byId.ifPresent(discuss -> map.put("discussList",discuss));
        return "detail";
    }
}

