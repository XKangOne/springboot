package com.example.exception;

import com.example.enums.CustomExceptionType;

public class CustomException extends RuntimeException{
//    异常错误编码
    private int code;
//    异常信息
    private String message;

    private CustomException(){

    }
    public CustomException(CustomExceptionType customExceptionType){
        this.code = customExceptionType.getCode();
        this.message = customExceptionType.getDesc();
    }

    public CustomException(CustomExceptionType customExceptionType, String message) {
        this.code = customExceptionType.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
