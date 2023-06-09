package com.example.task;

import org.springframework.stereotype.Component;

/***
 * @description: 同步任务调用子类
 * @author: yk
 **/
@Component
public class SyncTask extends AbstractTask{
    @Override
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }
}
