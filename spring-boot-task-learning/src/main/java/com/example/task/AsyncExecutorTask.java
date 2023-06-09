package com.example.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/***
 * @description: 通过线程池来调度任务
 * @author: yk
 **/
@Component
@Slf4j
public class AsyncExecutorTask extends AbstractTask{

    @Async("taskExecutor")
    public Future<String> doTaskOneCallBack() throws InterruptedException {
        super.doTaskOne();
        log.info("任务一，当前线程是:"+Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskTwoCallBack() throws InterruptedException {
        super.doTaskTwo();
        log.info("任务二，当前线程是:"+Thread.currentThread().getName());
        return new AsyncResult<>("任务二完成");
    }

}
