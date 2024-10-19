package com.xiaohan.demo.basic.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 * 模拟使用ThreadLocal存储用户上下文
 * 用户服务执行时，从当前线程的上下文中取出用户信息
 * </pre>
 */
public class App {

    private final static int CURRENT_USER_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(CURRENT_USER_THREAD);

        // 模拟10个并发用户线程，每个线程各自存储userId，线程间的本地变量相互隔离
        for (int i = 0; i < CURRENT_USER_THREAD; i++) {
            String userId = "userId-" + i;

            new Thread(() -> {
                // 存储用户上下文(相当于filter/interceptor)
                UserContextUtil.saveUserInfo(userId);
                try {
                    // 执行用户服务
                    UserService userService = new UserService();
                    userService.doSomething(userId);
                } finally {
                    UserContextUtil.removeUserInfo();
                    countDownLatch.countDown();
                }
            }).start();
        }

        // 等待线程执行结束
        countDownLatch.await();
    }
}