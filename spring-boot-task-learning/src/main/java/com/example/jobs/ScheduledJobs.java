package com.example.jobs;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.example.util.MyQrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/***
 * @description: 定时任务作业 启动是在启动主类运行
 * @author: yk
 **/
@Component
@Slf4j
public class ScheduledJobs {

    //表示方法执行完 5s 后继续执行
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedDelay 开始:---->"+LocalDateTime.now());
//        sleep(10 * 1000);
//        log.info("fixedDelay 结束:---->"+LocalDateTime.now());
//    }
//}

    //每个3秒
//    @Scheduled(fixedRate = 10000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedRate 开始:---->"+LocalDateTime.now());
//        sleep(5 * 1000);
//        log.info("fixedRate 结束:---->"+LocalDateTime.now());
//    }
//}

    //间隔10秒
    //x/y x是开始时间 y是间隔
    //Cron表达式
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void cronJob(){
//        log.info("cronJob 开始:---->"+LocalDateTime.now());
//    }

    //当前的时间
//    @Scheduled(cron = "0 25 15 4 4 ?")
    @Scheduled(fixedRate = 5000)
    public void cronJob(){
        log.info("生成二维码:---->"+LocalDateTime.now());
//        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
//        MyQrCodeUtil.createQrCode(String.valueOf(LocalDateTime.now()),"E:\\IDEA\\spring-boot-learning\\spring-boot-task-learning\\src\\main\\resources\\static\\image\\qrcode.jpg");
    }
}
