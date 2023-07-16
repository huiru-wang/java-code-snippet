package com.snippet.dubboserver.service;

import com.snippet.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * create by whr on 2023-07-16
 */
@Slf4j
@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public String userInfo(Long userId) {
        String userName = "";
        if (null == userId) {
            userName = "FAILED";
        } else {
            userName = "SUCCESS";
        }
        log.info("Dubbo RPC Request: {}:{}", userId, userName);
        return userName;
    }
}
