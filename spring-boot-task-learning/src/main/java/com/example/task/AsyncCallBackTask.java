package com.example.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/***
 * @description:异步回调
 * @author: yk
 **/
@Component
public class AsyncCallBackTask extends AbstractTask{

    @Async
    public Future<String> doTaskOneCallBack() throws InterruptedException {
        super.doTaskOne();
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwoCallBack() throws InterruptedException {
        super.doTaskTwo();
        return new AsyncResult<>("任务二完成");
    }
}
