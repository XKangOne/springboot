package com.example.controller;

import com.example.domain.Discuss;
import com.example.repository.DiscussRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * @description:
 * @author: yk
 **/
@RestController
@AllArgsConstructor
public class PageController {
    private DiscussRepository discussRepository;

    @GetMapping("page")
    public List<Discuss> geList(@RequestParam(name = "pageSize",defaultValue = "2") Integer pageSize,
                                @RequestParam(name = "pageNum",defaultValue = "0") Integer pageNum){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        List<Discuss> discusses = discussRepository.getDiscussesByPage2(1,pageable);
        return  discusses;
    }
}
