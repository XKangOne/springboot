package com.example.commons;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/***
 * @description:
 * @author: yk
 **/
//@Aspect
//@Component
//public class WebLogAspect {
//    private static final Logger logger = LogManager.getLogger(WebLogAspect.class);
//
//    @Pointcut("@annotation(com.example.log.annotation.MyLog)")
//    public void logPoinCut() {
//    }
//    //指定当前执行方法在logPointCut之前执行
//    @Before("LogPointCut()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable{
//        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
//        logger.info("请求地址" + request.getRequestURI().toString());
//        logger.info("HTTP METHOD:"+request.getMethod());
//        logger.info("CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "."
//                +joinPoint.getSignature().getName());
//        logger.info("参数："+ Arrays.toString(joinPoint.getArgs()));
//    }
//    /**
//     * @description 指定在方法之后返回
//     * @param:
//    */
//    @AfterReturning(returning = "ret",pointcut = "logPoinCut()")
//    public void doAfterReturning(Object ret){
//        //处理完请求，返回内容
//        logger.info("返回值："+ret);
//    }
//    @Around("logPointCut()")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
//        long startTime = System.currentTimeMillis();
//        Object ob = pjp.proceed();
//        logger.info("耗时："+(System.currentTimeMillis() - startTime));
//        return ob;
//    }
//}
