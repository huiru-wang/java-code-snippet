package com.snippet.javacodebase;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * create by whr on 2023-06-02
 */
public class ThreadLocalTest {

    Service service = new Service();

    @Test
    public void doTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> this.dosomething(countDownLatch, "user-1"));
        Thread thread2 = new Thread(() -> this.dosomething(countDownLatch, "user-2"));
        thread1.start();
        thread2.start();
        countDownLatch.wait();
    }

    private void dosomething(CountDownLatch countDownLatch, String userId) {
        ContextUtils.saveUserInfo(userId);
        service.dosomthing(countDownLatch, userId);
    }

}

class Service {
    public void dosomthing(CountDownLatch countDownLatch, String userId) {
        try {
            System.out.println(userId + " Done : " + ContextUtils.getUserInfo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ContextUtils.removeUserInfo();
            countDownLatch.countDown();
        }
    }
}

class ContextUtils {
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

