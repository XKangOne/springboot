package com.example.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/***
 * @description: 异步调用任务子类
 * @author: yk
 **/
@Component
public class AsyncTask extends AbstractTask {
    @Override
    @Async //不能修饰static方法
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    @Async
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }
}
