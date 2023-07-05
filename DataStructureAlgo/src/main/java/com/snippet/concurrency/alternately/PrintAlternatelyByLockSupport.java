package com.snippet.concurrency.alternately;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * 可以阻塞当前线程，唤醒指定线程
 * <p>
 * create by whr on 2023-07-05
 */
public class PrintAlternatelyByLockSupport {

    public static void main(String[] args) throws InterruptedException {
        Thread[] tasks = new Thread[2];
        tasks[0] = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("A");
                LockSupport.unpark(tasks[1]);  // 唤醒指定线程
                LockSupport.park(); // 阻塞当前线程
            }
        });
        tasks[1] = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                LockSupport.park();
                System.out.println("B");
                LockSupport.unpark(tasks[0]);
            }
        });
        tasks[0].start();
        tasks[1].start();
        tasks[0].join();
        tasks[1].join();
    }
}