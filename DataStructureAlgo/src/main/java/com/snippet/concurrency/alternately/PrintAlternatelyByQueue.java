package com.snippet.concurrency.alternately;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 无锁 阻塞队列交替执行任务
 * <p>
 * create by whr on 2023-07-05
 */
public class PrintAlternatelyByQueue {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> aQueue = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<String> bQueue = new ArrayBlockingQueue<>(1);
        Thread thread1 = new Thread(new PrintTask(aQueue, bQueue, 50, "B"));
        Thread thread2 = new Thread(new PrintTask(bQueue, aQueue, 50, "A"));
        aQueue.add("A");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class PrintTask implements Runnable {

    private final ArrayBlockingQueue<String> targetQueue;
    private final ArrayBlockingQueue<String> nextQueue;

    private final String next;

    private int taskNum;

    public PrintTask(ArrayBlockingQueue<String> targetQueue, ArrayBlockingQueue<String> nextQueue, int taskNum, String next) {
        this.targetQueue = targetQueue;
        this.nextQueue = nextQueue;
        this.taskNum = taskNum;
        this.next = next;
    }

    @Override
    public void run() {
        while (taskNum > 0) {
            try {
                String poll = targetQueue.poll(1000L, TimeUnit.MILLISECONDS);
                System.out.println(poll);
                taskNum--;
                nextQueue.add(next);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
