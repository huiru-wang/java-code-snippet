package com.xiaohan.demo.spring.mvc.controller;

import com.xiaohan.demo.spring.mvc.model.ServiceResult;
import com.xiaohan.demo.spring.mvc.model.request.TestRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * create by whr on 2023/2/19
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("param/{id}")
    public ServiceResult<String> testPathVariable(@PathVariable String id) {
        return ServiceResult.success("userTest got id: [ " + id + " ]");
    }

    @GetMapping("testParam")
    public ServiceResult<String> testParam(@RequestParam String message) {
        return ServiceResult.success("userTest got message: [ " + message + " ]");
    }

    @GetMapping("testRequest")
    public ServiceResult<String> testRequest(TestRequest testRequest) {
        String id = testRequest.getId();
        String message = testRequest.getMessage();
        return ServiceResult.success("userTest got testRequest: [ " + "{id: " + id + "}, {message: " +message + "} ]");
    }

}
