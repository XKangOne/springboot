package com.example.service;

import com.example.domain.Ariticle;
import com.example.enums.CustomExceptionType;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionService {
//    服务层 模拟系统异常
//    public void systemBizError(){
//        throw new CustomException(CustomExceptionType.SYSTEM_ERROR, MsgConsts.PARAM_ERROR);
//    }
//    服务层,模拟用户输入数据导致的校验失败
//    public void userBizError(int input){
//        if (input <= 0){
//            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,MsgConsts.INPUT_ERROR);
//        }
//    }
//    服务层，模拟未认证异常
    public void authError(){
        throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
    }
    /**
     * 服务层，模拟参数霓裳
     */
    public Ariticle getArticle(int id){
//        模拟业务校验失败逻辑
        if (id<= 0){
            throw new CustomException(CustomExceptionType.PARAM_ERROR);
        }
        return findArticleById(id);
    }
    private Ariticle findArticleById(int id) {
        List<Ariticle> articles = List.of(
                new Ariticle(1,"Spring 从入门到精通","大佬"),
                new Ariticle(2,"SpringBoot 从入门到精通","大牛"),
                new Ariticle(3,"Spring CLoud 从入门到精通","大神")
        );
        return articles.stream().filter(article -> article.getId() == id).toList().get(0);
    }
}
