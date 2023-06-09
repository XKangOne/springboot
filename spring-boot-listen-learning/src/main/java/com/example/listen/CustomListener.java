package com.example.listen;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

/***
 * @description:
 * @author:
 **/
@Slf4j
@WebListener
public class CustomListener implements ServletContextListener, HttpSessionListener, ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("------------"+"context 创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("------------"+"context 销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("------------"+"request 初始化");
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("------------"+"request 销毁");
    }



    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("------------"+"session 创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("------------"+"session 销毁");
    }

//    @Override
//    public void attributeAdded(ServletRequestAttributeEvent srae) {
//        ServletRequestAttributeListener.super.attributeAdded(srae);
//    }
//
//    @Override
//    public void attributeRemoved(ServletRequestAttributeEvent srae) {
//        ServletRequestAttributeListener.super.attributeRemoved(srae);
//    }
//
//    @Override
//    public void attributeReplaced(ServletRequestAttributeEvent srae) {
//        ServletRequestAttributeListener.super.attributeReplaced(srae);
//    }
}