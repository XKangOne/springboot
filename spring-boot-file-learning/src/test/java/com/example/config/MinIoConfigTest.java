package com.example.config;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/***
 * @description:
 * @author: yk
 **/

@SpringBootTest
@Slf4j
class MinIoConfigTest {
    @Resource
    private MinIoConfig minIoConfig;

    @Test
    void makeBucket() throws Exception{
        minIoConfig.makeBucket("hello1");
    }
    @Test
    void uploadObject() throws Exception{
        ObjectWriteResponse response =
                minIoConfig.uploadObject("hello", "img/banner.jpg", "D:\\Git\\upload\\20230410\\a.jpg");
        log.info(response.object());
    }

    @Test
    void removeObject() throws Exception{
        minIoConfig.removeObject("hello","img/banner.jpg");
    }
}