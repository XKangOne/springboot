package com.example.generator;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/***
 自定义key生成

 如果上述的 key 获取方式都不足以满足需要，
 我们还可以使用自定义 key 策略实现。编写自定义策略时，
 需要实现 KeyGenerator 接口并重写 generate 方法，
 generate 方法中可以拿到被标注 @Cacheable 注解标注的方法、目标对象，以及方法输入的参数列表。
 **/
@Component
public class UserKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName() + params[0];
    }
}