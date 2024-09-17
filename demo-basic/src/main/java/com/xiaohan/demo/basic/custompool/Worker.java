package com.xiaohan.demo.basic.custompool;

import java.util.concurrent.BlockingQueue;

/**
 * <pre>
 * 可中断的线程Worker对象
 * 也是安全停止线程的方式：优雅停止，等待线程的当前任务执行结束
 * </pre>
 */
public class Worker extends Thread {

    private final int id;

    private final BlockingQueue<Runnable> queue;

    public Worker(BlockingQueue<Runnable> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        String workerName = Thread.currentThread().getName() + "-" + id;
        try {
            while (!Thread.currentThread().isInterrupted()) { // 每次判断是否被中断
                Runnable task = queue.take();
                System.out.println(workerName + " is running");
                task.run();
            }
        } catch (InterruptedException e) {
            System.out.println(workerName + " is interrupted");
        }
    }
}
