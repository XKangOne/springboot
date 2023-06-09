package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/***
 * @description: 异步任务线程池配置
 * @author: yk
 **/
@Configuration
public class TaskConfig {

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(12);
        //最大线程数
        executor.setMaxPoolSize(26);
        //线程队列数量
        executor.setQueueCapacity(2000);
        //空闲线程存活时间
        executor.setKeepAliveSeconds(120);
        //池中任务全部完成再关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置线程池中任务的等待时间,如果超过这个时间还没有销毁就强制销毁,以确保应用最后能够被关闭，而不是阻塞住
        executor.setAwaitTerminationSeconds(180);
        //线程名称前缀
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }
}
