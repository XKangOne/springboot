package com.example.controller;

import com.example.domain.Discuss;
import com.example.repository.DiscussRepository;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/***
 * @description:
 * @author: yk
 **/
@Controller
public class DiscussController {
    @Resource
    private DiscussRepository discussRepository;

    @GetMapping("/discuss")
    public String getDiscuss(ModelMap map){
        Pageable pageable = PageRequest.of(1, 2);
//        List<Discuss> list = discussRepository.getDiscussesByPage(pageable);
        List<Discuss> list = discussRepository.getDiscussesByPage1(1,pageable);
        map.put("discussList",list);
        map.put("title","hello world");
        return "index";
    }
}
