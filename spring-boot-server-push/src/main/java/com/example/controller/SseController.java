package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/***
 * @description: SSE 服务端推送事件demo
 * @author: yk
 **/
@Controller
@Slf4j
public class SseController {

    @RequestMapping(value = "/sse/msg",method = RequestMethod.GET,produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter pushMsg(){
        //加人2L才使得不断推送消息
       final SseEmitter emitter = new SseEmitter(2L);
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        log.info("emitter push msg...");
//        LocalDateTime data = LocalDateTime.now();
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = sdf.format(day);
        Random math = new Random();
        int i = math.nextInt(20);
        String msg = data +" "+"当前股票的价格:"+i+"元";
        try {
            emitter.send(msg, MediaType.TEXT_EVENT_STREAM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return emitter;
    }
}

