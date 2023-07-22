package com.snippet.dubboclient.service;

import com.alibaba.fastjson2.JSON;
import com.snippet.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * create by whr on 2023-07-16
 */
@Slf4j
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void test_dubbo_rpc_user() {
        User user = userController.userInfo(1L);
        log.info("RPC Response: {}", JSON.toJSONString(user));
    }
}
