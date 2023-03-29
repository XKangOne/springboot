package com.example.enums;

import com.example.consts.Consts;
import lombok.Getter;
import com.example.consts.MsgConsts;

@Getter
public enum CustomExceptionType {
    PARAM_ERROR(Consts.CODE_400,Consts.PARAM_ERROR),
    UNAUTHORIZED_ERROR(Consts.CODE_401,Consts.UNAUTHORIZED_ERROR),
    FORBIDDEN_ERROR(Consts.CODE_500,Consts.FORBIDDEN_ERROR),
    //    客户端异常
//    USER_INPUT_ERROR(400, MsgConsts.INPUT_ERROR),
    //    服务异常类
    SYSTEM_ERROR(500,MsgConsts.SYSTEM_ERROR ),
    //    未知异常
    OTHER_ERROR(999,MsgConsts.OTHER_ERROR);
    CustomExceptionType(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }
//    异常类型状态码
    private final int code;
//    异常类型中文描述
    private final String desc;
}
