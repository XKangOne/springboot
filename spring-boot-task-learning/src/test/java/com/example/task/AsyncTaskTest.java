package com.example.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.System.currentTimeMillis;
import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 **/
@SpringBootTest
@Slf4j
class AsyncTaskTest {
    @Resource
    private AsyncTask asyncTask;

    @Test
    void testSyncTask() throws InterruptedException {
        long start = currentTimeMillis();
        //异步并发执行
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        long end = currentTimeMillis();
        log.info("完成所以任务,总耗时"+(end - start)+"毫秒");
    }
}