package com.example.util;

import com.example.enums.CustomExceptionType;
import lombok.Data;
import com.example.exception.CustomException;

@Data
public class AjaxResponse {
    private int code;
    private  String message;
    private Object data;
    private AjaxResponse(){

    }
    public static AjaxResponse error(CustomException e){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    public static AjaxResponse error(CustomExceptionType customExceptionType, String errorMessage){
        AjaxResponse resultBean =  new AjaxResponse();
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功！");
        return ajaxResponse;
    }

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    public  static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
