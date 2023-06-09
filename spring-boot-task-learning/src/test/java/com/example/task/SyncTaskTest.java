package com.example.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/***
 * @description:
 * @author: yk
 * @date:
 **/
@SpringBootTest
@Slf4j
class SyncTaskTest {
    @Resource
    private SyncTask syncTask;

    @Test
    void testSyncTask() throws InterruptedException {
        long start = currentTimeMillis();
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        long end = currentTimeMillis();
        log.info("完成所以任务,总耗时"+(end - start)+"毫秒");
    }
}