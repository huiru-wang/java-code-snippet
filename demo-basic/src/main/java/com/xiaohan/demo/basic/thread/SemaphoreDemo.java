package com.xiaohan.demo.basic.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * semaphore用来控制同时访问特定资源的线程数量
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        // 初始化信号量为：3
        Semaphore tickets = new Semaphore(3);

        // 创建10个线程
        for (int i = 0; i < 10; i++) {
            Thread customer = createTask(tickets, i);
            customer.start();
        }

        // 主线程等待
        TimeUnit.SECONDS.sleep(21);
    }

    private static Thread createTask(Semaphore tickets, int count) {
        return new Thread(() -> {
            try {
                // 从信号量中取锁，并占用2秒
                tickets.acquire();
                System.out.println("customer " + count + " get the ticket.");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                // 归还
                tickets.release();
                System.out.println("------------------------ customer " + count + " return the ticket.");
            }
        });
    }
}
