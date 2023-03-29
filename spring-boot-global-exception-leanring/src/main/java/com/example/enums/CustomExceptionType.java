package com.example.enums;

import com.example.consts.Consts;
import lombok.Getter;

/***
 * @description: 异常类型枚举
 * 枚举默认是私有
 **/
@Getter
public enum CustomExceptionType {
    PARAM_ERROR(Consts.CODE_400, Consts.PARAM_ERROR),
    UNAUTHORIZED_ERROR(Consts.CODE_401, Consts.UNAUTHORIZED_ERROR),
    FORBIDDEN_ERROR(Consts.CODE_403, Consts.FORBIDDEN_ERROR),
    SYSTEM_ERROR(Consts.CODE_500, Consts.SYSTEM_ERROR),
    OTHER_ERROR(Consts.CODE_999, Consts.OTHER_ERROR);
//    //客户端异常
//    USE_INPUT_ERROR(400,MsgConsts.INPUT_ERROR),
//    //服务器异常
//    SYSTEM_ERROR(500, MsgConsts.SYSTEM_ERROR),
//    //未知异常
//    OTHER_ERROR(999,MsgConsts.OTHER_ERROR);

     private CustomExceptionType(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }
    //异常类型状态码
    private final int code;
    //异常类型中文描述
    private final String desc;
}
