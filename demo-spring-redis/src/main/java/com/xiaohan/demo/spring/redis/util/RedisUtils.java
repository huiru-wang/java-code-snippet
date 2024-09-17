package com.xiaohan.demo.spring.redis.util;

public class RedisUtils {

    private static final String UNDER_LINE = "_";

    public static String buildKey(String prefix, String ...items) {
        return prefix + UNDER_LINE + String.join(UNDER_LINE, items);
    }
}
