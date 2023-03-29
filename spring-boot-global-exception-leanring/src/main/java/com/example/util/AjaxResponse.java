package com.example.util;

import com.example.enums.CustomExceptionType;
import com.example.exception.CustomException;
import lombok.Data;

/***
 * @description: 请求接口统一响应数据结构
 * @author: yk
 **/
@Data
public class AjaxResponse {
    //请求响应状态码
    private int code;
    //请求结果描述信息
    private String message;
    //请求结果数据(通常用于查询操作)
    private Object data;
    private AjaxResponse(){
    }
    //请求出现异常时的响应数据封禁
    public static AjaxResponse error(CustomException e){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }
    //请求出现异常时的响应数据封装
    public static AjaxResponse error(CustomExceptionType customExceptionType,String errorMessage){
        AjaxResponse resulteBean = new AjaxResponse();
        resulteBean.setCode(customExceptionType.getCode());
        resulteBean.setMessage(errorMessage);
        return resulteBean;
    }
    //请求成功的响应，不带查询数据(用于删除，修改，新增接口)
    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        return ajaxResponse;
    }
    //请求成功的响应，带查询数据(用于数据查询接口)
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功！");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
    //请求成功的响应，带查询数据(用于数据查询接口)
    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
