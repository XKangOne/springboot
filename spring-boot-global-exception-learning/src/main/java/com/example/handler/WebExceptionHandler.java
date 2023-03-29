package com.example.handler;

import com.example.enums.CustomExceptionType;
import com.example.util.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.exception.CustomException;

@ControllerAdvice
@Slf4j
public class WebExceptionHandler {
    //    处理程序员主动抛出的自定义异常
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public AjaxResponse handleBindException(MethodArgumentNotValidException ex) {
//        FieldError fieldError = ex.getBindingResult().getFieldError();
//        assert fieldError != null;
//        return AjaxResponse.error(new CustomException(CustomExceptionType.PARAM_ERROR, fieldError.getDefaultMessage()));
//    }
//
//    @ExceptionHandler(BindException.class)
//    @ResponseBody
//    public AjaxResponse handleBindException(BindException ex) {
//        FieldError fieldError = ex.getBindingResult().getFieldError();
//        assert fieldError != null;
//        return AjaxResponse.error(new CustomException(CustomExceptionType.PARAM_ERROR, fieldError.getDefaultMessage()));
//    }
}
