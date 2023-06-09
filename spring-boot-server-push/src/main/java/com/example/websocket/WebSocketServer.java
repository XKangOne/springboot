package com.example.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/***
 * @description: SpringBoot 服务端 WebSocket 服务类定义
 * @author: yk
 **/
@Component
@ServerEndpoint(value = "/socket/{id}")
@Slf4j
public class WebSocketServer {
    //静态变量，用来统计在线的连接数
    private static int onlineCount = 0;

    //与某个客户端连接的会话，存放了和客户端连接对应的 WebSocket 对象
    private Session session;
    private Integer id;
    //concurrent 包：线程安全的集合，用来存放和每个客户端对应的WebSocket对象
    public static ConcurrentHashMap<Integer, WebSocketServer> map = new ConcurrentHashMap<>();

    /**
     连接建立成功调用的方法
     @PathParam 请求路径参数
    */
    @OnOpen
    public void onOpen(@PathParam(value = "id") Integer id, Session session){
        log.info("连接成功");
        //接收的编号
        this.id = id;
        this.session = session;
        //加入集合
        map.put(id, this);
        //在线人数+1
        addOnlineCount();
        log.info("有新连接加入，当前在线人数为："+getOnlineCount());
        sendMessage("--连接已经成功建立--");

    }
    @OnClose
    public void onClose(){
        log.info("有连接关闭，当前在线人数为："+getOnlineCount());
        //从map移除
        //在线人数-1
        subOnlineCount();
    }

    //收到客户端发送消息后，调用的方法
    @OnMessage
    public void onMessage(Session session,String msg){
        log.info("接收到客户端发送的消息"+msg);
//        this.sendMessage(msg);
        this.broadcastMsg(msg);
    }
    @OnError
    public void onError(Throwable error){
        log.error(error.getMessage());
        error.printStackTrace();
    }
    //群发消息 msg：消息
    private void sendMessage(String msg){
        try {
            getSession().getBasicRemote().sendText(msg);
        } catch (IOException e) {
            log.error("发生错误");
        }
    }

    //单发消息,给指定的id发送消息 msg：消息
    private void sendMessageById(Integer id, String msg) {
        WebSocketServer webSocketServer = map.get(id);
        if (map.get(id) != null){
            webSocketServer.sendMessage(msg);
        }else {
            log.info("客户端已下线,不能发送消息");
        }
    }
    //群发自定义消息
    private void broadcastMsg(String msg) {
        for (WebSocketServer item : map.values()) {
            item.sendMessage(msg);
        }
    }
    public Session getSession(){
        return session;
    }
    //通过synchronized 给方法加载，实现线程安全
    public static synchronized void addOnlineCount(){
        WebSocketServer.onlineCount++;
    }
    public static synchronized void subOnlineCount(){
        WebSocketServer.onlineCount--;
    }
    public static synchronized int getOnlineCount(){
       return WebSocketServer.onlineCount;
    }
}
