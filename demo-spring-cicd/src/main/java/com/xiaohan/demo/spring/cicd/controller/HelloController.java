package com.xiaohan.demo.spring.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/cicd")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Got it";
    }
}
