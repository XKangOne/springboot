package com.example.boot.controller;

import com.example.boot.config.DBConfig;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @description:
 * @author: yk
 **/
@RestController
@AllArgsConstructor
public class DBConController {
    private final DBConfig dbConfig;

    @GetMapping("/show")
    public String show(){
        return dbConfig.configure();
    }
}
