package com.example.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/***
 * @description: 通过线程池来调度任务
 * @author: yk
 **/
@SpringBootTest
@Slf4j
class AsyncExecutorTaskTest {

    @Resource
    private AsyncExecutorTask task;

    @Test
    void test() throws InterruptedException {
        task.doTaskOneCallBack();
        task.doTaskTwoCallBack();
        sleep(10*1000L);
    }

}