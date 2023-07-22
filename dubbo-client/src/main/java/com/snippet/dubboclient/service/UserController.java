package com.snippet.dubboclient.service;

import com.snippet.api.UserService;
import com.snippet.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by whr on 2023-07-16
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @DubboReference(
            registry = {"nacos"},
            protocol = "dubbo",
            version = "0.0.1",  // 指定服务版本
            loadbalance = LoadbalanceRules.SHORTEST_RESPONSE,
            retries = 3,
            timeout = 10000,
            check = false,  // 启动时检查是否有服务提供，没有则启动失败
            mock = "userServiceMock"    // 服务降级处理的Bean
    )
    private UserService userService;


    @GetMapping("/info/{userId}")
    public User userInfo(@PathVariable("userId") Long userId) {
        String userName = userService.userInfo(userId);
        log.info("Dubbo RPC Response: {}", userName);
        return new User(userId, userName);
    }

    @DubboReference(
            protocol = "dubbo",
            version = "0.0.2"
    )
    private UserService userService2;

    @GetMapping("/info2/{userId}")
    public User userInfo2(@PathVariable("userId") Long userId) {
        String userName = userService2.userInfo(userId);
        log.info("Dubbo RPC Response: {}", userName);
        return new User(userId, userName);
    }

}
