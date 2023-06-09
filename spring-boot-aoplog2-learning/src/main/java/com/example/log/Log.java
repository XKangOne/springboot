package com.example.log;

/***
 * @description:
 * @author: yk
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用@interface将定义一个注解 这里是log
 * 用于日志aop编程
 *
 * Annotation 注解的作用：
 *
 * @interface 表示这是一个注解类， 不是interface，是注解类 定义注解用的，是jdk1.5之后加入的，java没有给它新的关键字，所以就用@interface 这么个东西表示了
 *
 * @Inherited //这个Annotation 可以被继承
 *
 * @Documented //这个Annotation可以被写入javadoc
 *
 * @Target:注解的作用目标
 *
 * @Target(ElementType.TYPE) //接口、类、枚举、注解
 * @Target(ElementType.FIELD) //字段、枚举的常量
 * @Target(ElementType.METHOD) //方法
 * @Target(ElementType.PARAMETER) //方法参数
 * @Target(ElementType.CONSTRUCTOR) //构造函数
 * @Target(ElementType.LOCAL_VARIABLE)//局部变量
 * @Target(ElementType.ANNOTATION_TYPE)//注解
 * @Target(ElementType.PACKAGE) ///包
 *
 * @Retention(RetentionPolicy.RUNTIME) //可以用来修饰注解，是注解的注解，称为元注解。
 * */
@Target(ElementType.METHOD)  //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
public @interface Log {
    String value() default "";
}