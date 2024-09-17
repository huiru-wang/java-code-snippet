package com.xiaohan.demo.basic.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 控制线程执行顺序
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 初始化，可以控制3个线程
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // 创建3个线程
        for (int i = 0; i < 3; i++) {
            createTask(countDownLatch, i).start();
        }
        // 阻塞等待3个任务执行完毕
        countDownLatch.await();

        // 3个任务执行完毕，执行主线程
        System.out.println("Main Task begin");
    }

    private static Thread createTask(CountDownLatch countDownLatch, int count) {
        return new Thread(() -> {
            System.out.println("Sub Task " + count + " is prepare");
            try {
                // 线程内执行任务2秒
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                // 线程执行任务完毕
                System.out.println("Sub Task " + count + " is ready");
                countDownLatch.countDown();
            }
        });
    }
}
