package com.example.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/****
 通过@Bean定义方式实现
 这种方式可以指定执行顺序，注意前两个Bean是CommandLineRunner，最后一个Bean是ApplicationRunner 。
 **/
@Configuration
@Slf4j
public class BeanRunner {
    @Bean
    @Order(1)
    public CommandLineRunner runner1() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                log.info("BeanCommandLineRunner run1()" + Arrays.toString(args));
            }
        };
    }

    @Bean
    @Order(2)
    public CommandLineRunner runner2() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                log.info("BeanCommandLineRunner run2()" + Arrays.toString(args));
            }
        };
    }

    @Bean
    @Order(3)
    public ApplicationRunner runner3() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) {
                log.info("BeanApplicationRunner run3()" + Arrays.toString(args.getSourceArgs()));
            }
        };
    }
}