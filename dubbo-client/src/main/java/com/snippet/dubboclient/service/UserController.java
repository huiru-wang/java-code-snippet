package com.snippet.dubboclient.service;

import com.snippet.api.UserService;
import com.snippet.model.User;
import lombok.extern.slf4j.Slf4j;
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
            protocol = "dubbo",
            loadbalance = "random"
    )
    private UserService userService;

    @GetMapping("/info/{userId}")
    public User userInfo(@PathVariable("userId") Long userId) {
        String userName = userService.userInfo(userId);
        log.info("Dubbo RPC Response: {}", userName);
        return new User(userId, userName);
    }
}
