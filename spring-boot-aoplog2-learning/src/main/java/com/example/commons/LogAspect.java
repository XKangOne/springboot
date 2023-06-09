package com.example.commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;


/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LogManager.getLogger(LogAspect.class);
    /**
     * 这里指定使用 @annotation 指定com.fishpro.aoplog.annotation.Log log注解
     * */
    @Pointcut("@annotation(com.example.log.Log)")
    public void logPointCut(){
    }
    public  Object around(ProceedingJoinPoint point) throws Throwable{
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志 这里是文本日志
        return result;
    }
    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException{
    }
}