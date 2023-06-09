package com.example.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 **/
@SpringBootTest
@Slf4j
class AsyncCallBackTaskTest {

    @Resource
    private AsyncCallBackTask asyncCallBackTask;

    @Test
    void testSyncTask() throws InterruptedException {
        long start = currentTimeMillis();

        Future<String> task1 = asyncCallBackTask.doTaskOneCallBack();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallBack();

        //二个任务都有调用完成，退出等待
        while (!task1.isDone() || !task2.isDone()){
            sleep(1000);
        }
        long end = currentTimeMillis();
        log.info("完成所以任务,总耗时"+(end - start)+"毫秒");
    }
}