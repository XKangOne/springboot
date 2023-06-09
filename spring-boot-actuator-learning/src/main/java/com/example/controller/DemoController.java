package com.example.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @description: 自定义metrics端口 访问地址：localhost:8080/actuator/metrics/demo.request
 *
 * 监控接口调用的次数
 * @author: yk
 **/
@RestController
public class DemoController {

    @Resource
    private MeterRegistry meterRegistry;

    private Counter counter;

    @PostConstruct
    public void init() {
        //拓展端点
        counter = meterRegistry.counter("demo.request");
    }

    @GetMapping("/demo")
    public String demo(){
        counter.increment();
        return "demo";
    }
}
