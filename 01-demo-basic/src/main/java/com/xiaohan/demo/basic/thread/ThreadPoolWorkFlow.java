package com.xiaohan.demo.basic.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 1、线程会先占用核心池，满了(最大核心+队列)之后去队列等待；
 * 2、队列满了之后，如果还没有达到最大线程数量，继续创建线程；
 * 3、到最大线程数，启动拒绝策略；
 * </pre>
 * <pre>
 * PoolSize: 1,Queue[]  任务直接交给核心线程
 * PoolSize: 2,Queue[]  任务直接交给核心线程
 * PoolSize: 2,Queue[Task_2]    核心线程满，放入队列
 * PoolSize: 2,Queue[Task_2, Task_3]
 * PoolSize: 2,Queue[Task_2, Task_3, Task_4]
 * PoolSize: 2,Queue[Task_2, Task_3, Task_4, Task_5]
 * PoolSize: 2,Queue[Task_2, Task_3, Task_4, Task_5, Task_6]
 * PoolSize: 3,Queue[Task_2, Task_3, Task_4, Task_5, Task_6]  队列满，增加线程数，直到满足最大线程
 * Rejected：Task_8   启动拒绝策略
 * </pre>
 * create by whr on 2023/2/15
 */
public class ThreadPoolWorkFlow {

    private static final int CORE_POOL_SIZE = 2;

    private static final int MAX_POOL_SIZE = 4 ;

    private static final int QUEUE_SIZE = 5;


    // 2+3 总共5个线程，总计可以同时持有任务3+5=8个
    private static final ThreadPoolExecutor threadPoll = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            2000,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(QUEUE_SIZE),
            new MyRejectedHandler());

    public static void main(String[] args) throws InterruptedException {
        // 创建 10 个任务添加
        for (int i = 0; i < 10; i++) {
            String name = "Task_" + i;
            Task task = new Task(name);
            try {
                threadPoll.execute(task);
                if (QUEUE_SIZE == threadPoll.getQueue().size() && threadPoll.getPoolSize() < MAX_POOL_SIZE) {
                    // 队列满，线程池未满，任务继续添加线程到线程池内的非核心池中
                    System.out.println("=============== Queue Is Full ==============");
                    System.out.println("PoolSize: " + threadPoll.getPoolSize() + ", Queue" + threadPoll.getQueue());
                } else if (threadPoll.getPoolSize() <= MAX_POOL_SIZE){
                    // 队列未满，任务加入队列
                    System.out.println("PoolSize: " + threadPoll.getPoolSize() + ", Queue" + threadPoll.getQueue());
                }
            } catch (Exception e) {
                System.out.println("Refused:" + name);
            }
        }

        threadPoll.shutdown();
        threadPoll.awaitTermination(5, TimeUnit.MINUTES); // 阻塞等待线程池关闭,返回是否关闭成功
    }

    /**
     * 线程
     */
    static class Task implements Runnable {
        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    /**
     * 线程 拒绝策略
     */
    static class MyRejectedHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Rejected：" + r.toString());
        }
    }
}
