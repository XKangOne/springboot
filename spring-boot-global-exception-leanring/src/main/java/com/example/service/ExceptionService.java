package com.example.service;

import com.example.domain.Article;
import com.example.enums.CustomExceptionType;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/***
 * @description: 统用异常处理逻辑
 * @author: yk
 **/
@Service
public class ExceptionService {
    //服务器，模拟系统异常
    public void systemBizError(){
//        throw new CustomException(CustomExceptionType.SYSTEM_ERROR, MsgConsts.PARAM_ERROR);
        throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
    }
    //服务器,模拟未认证异常
    public void authError(){
        throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
    }
    //服务器，模拟用户输入数据导致的校验异常
    public void userBizError(int input){
        if (input <=0){
//            throw new CustomException(CustomExceptionType.USE_INPUT_ERROR, MsgConsts.INPUT_ERROR);
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }
    }
    //服务器,模拟参数异常
    public Article getArticle(int id){
        //模拟业务校验失败逻辑
        if (id <= 0) {
            throw new CustomException(CustomExceptionType.PARAM_ERROR);
        }
        return findArticleById(id);
    }
//    private Article findArticleById(int id){
//       List<Article> articles = List.of(
//               new Article(1,"Spring 从入门到精通","大佬"),
//                new Article(2,"Spring 从入门到精通","大牛"),
//               new Article(3,"Spring 从入门到精通","大神")
//       );
//       return articles.stream().filter(article -> article.getId() == id).toList().get(0);
//   }
    private Article findArticleById(int id){
        List<Article> articles = List.of(
            new Article(1,"Spring 从入门到精通","大佬","spring@qq.com", LocalDateTime.of(2023,2,3,4,1,2)),
            new Article(2,"Spring 从入门到精通","大牛","springboot@qq.com",LocalDateTime.of(2023,2,3,4,1,2)),
            new Article(3,"Spring 从入门到精通","大神","spring@qq.com",LocalDateTime.of(2023,2,3,4,1,2))
    );
    return articles.stream().filter(article -> article.getId() == id).toList().get(0);
}
}
