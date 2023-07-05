package com.snippet.concurrency.alternately;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印AB
 * 不要使用线程空转的方法，使用阻塞 + 唤醒
 * <p>
 * create by whr on 2023-07-02
 */
public class PrintAlternatelyByLock {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final Condition CONDITION = LOCK.newCondition();

    private static volatile int COUNT = 100;

    CountDownLatch latch;

    public PrintAlternatelyByLock(CountDownLatch latch) {
        this.latch = latch;
    }

    private void printTask(String value, Integer state) {
        while (COUNT > 0) {
            try {
                LOCK.lock();
                while (COUNT % 2 != state) {
                    CONDITION.await(); // 不满足条件 释放锁
                }
                System.out.println(value + "-" + COUNT--);
                CONDITION.signal();  // 执行完成一次 唤醒另一个线程
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                LOCK.unlock();
            }
        }
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        PrintAlternatelyByLock task = new PrintAlternatelyByLock(latch);
        new Thread(() -> task.printTask("A", 0)).start();
        new Thread(() -> task.printTask("B", 1)).start();
        latch.await();
    }
}
