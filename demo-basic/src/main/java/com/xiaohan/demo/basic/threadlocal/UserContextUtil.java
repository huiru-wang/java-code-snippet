package com.xiaohan.demo.basic.threadlocal;

public class UserContextUtil {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void saveUserInfo(String userId) {
        threadLocal.set(userId);
    }

    public static String getUserInfo() {
        return threadLocal.get();
    }

    public static void removeUserInfo() {
        threadLocal.remove();
    }
}
