package com.example.consts;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
public interface Consts {
    //code 常量维护
    int CODE_200 = 200;
    int CODE_400 = 400;
    int CODE_401 = 401;
    int CODE_403 = 403;
    int CODE_500 = 500;
    int CODE_999 = 999;

    //message 常量维护
    String SUCCESS = "请求响应成功！";
    String PARAM_ERROR = "参数非法";
    String UNAUTHORIZED_ERROR = "身份未认证";
    String FORBIDDEN_ERROR = "访问被拒绝";
    String SYSTEM_ERROR = "系统出现异常,请稍后再试或联系管理员！";
    String OTHER_ERROR = "系统出现未知异常，请联系管理员！";
}
