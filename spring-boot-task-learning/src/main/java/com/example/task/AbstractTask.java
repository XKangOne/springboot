package com.example.task;

import lombok.extern.slf4j.Slf4j;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/***
 * @description: 任务抽象类
 * @author: yk
 **/
@Slf4j
public abstract class AbstractTask {
    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一");
        long start = currentTimeMillis();
        sleep(10000);
        long end = currentTimeMillis();
        log.info("完成任务一,耗时"+(end - start)+"毫秒");
    }
    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long start = currentTimeMillis();
        sleep(5000);
        long end = currentTimeMillis();
        log.info("完成任务二,耗时"+(end - start)+"毫秒");
    }
}
