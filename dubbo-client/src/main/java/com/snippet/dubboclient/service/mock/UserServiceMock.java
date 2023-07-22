package com.snippet.dubboclient.service.mock;

import com.snippet.api.UserService;
import org.springframework.stereotype.Service;

/**
 * create by whr on 2023-07-22
 */
@Service
public class UserServiceMock implements UserService {
    @Override
    public String userInfo(Long aLong) {
        return "Mock User";
    }
}
