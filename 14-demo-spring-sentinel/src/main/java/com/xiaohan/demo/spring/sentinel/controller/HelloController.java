package com.xiaohan.demo.spring.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/sentinel")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Got it";
    }

    @GetMapping("/delay")
    public String delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Got it";
    }
}
