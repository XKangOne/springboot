package com.example.controller;

import com.example.auth.CheckAuth;
import com.example.domain.Ariticle;
import com.example.util.AjaxResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.service.ExceptionService;

@RestController
@RequestMapping(value = "api")
public class TestController {
    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/ariticles/{id}")
    @CheckAuth(value = "Admin123")
    public AjaxResponse getArticle(@PathVariable int id) {
        return AjaxResponse.success(exceptionService.getArticle(id));
    }

    @PostMapping("/ariticles")
    public AjaxResponse saveArticle(@Valid @RequestBody Ariticle ariticle) {
        return AjaxResponse.success(ariticle);
    }
}
