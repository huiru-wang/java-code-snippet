package com.xiaohan.demo.spring.mvc.util;

import java.util.UUID;

public class IdUtils {

    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
