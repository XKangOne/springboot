package com.example.config;

import com.example.Main;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/***
 * @description: 自定义的info端口 访问地址：localhost:8080/actuator/info
 * @author: yk
 **/
@Component
public class ApplicationInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("appName","spring-boot-actuator");
        Map<String, Object> data = new HashMap<>();
        data.put("version", "1.0.0");
        data.put("author", "yk");
        builder.withDetails(data);
    }
}
