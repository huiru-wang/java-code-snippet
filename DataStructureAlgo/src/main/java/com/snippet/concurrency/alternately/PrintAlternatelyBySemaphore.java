package com.snippet.concurrency.alternately;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 通过两个信号量，交替释放令牌，和队列类似
 * acquire: -1
 * release: +1
 * <p>
 * create by whr on 2023-07-05
 */
public class PrintAlternatelyBySemaphore {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreA = new Semaphore(0);
        Semaphore semaphoreB = new Semaphore(0);
        Thread thread1 = new Thread(new SemaphoreTask(semaphoreA, semaphoreB, "A", 50));
        Thread thread2 = new Thread(new SemaphoreTask(semaphoreB, semaphoreA, "B", 50));
        semaphoreA.release();   // 先给A任务释放一个令牌
        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();
    }
}

class SemaphoreTask implements Runnable {
    private final Semaphore self;

    private final Semaphore next;

    private int count;

    private final String target;

    public SemaphoreTask(Semaphore self, Semaphore next, String target, int count) {
        this.self = self;
        this.next = next;
        this.target = target;
        this.count = count;
    }

    @Override
    public void run() {
        // 交替释放令牌，和队列类似
        while (count > 0) {
            try {
                if (self.tryAcquire(1000L, TimeUnit.MILLISECONDS)) {
                    System.out.println(target);
                    count--;
                    next.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
