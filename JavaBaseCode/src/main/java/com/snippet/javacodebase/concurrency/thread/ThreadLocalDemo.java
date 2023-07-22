package com.snippet.javacodebase.concurrency.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * create by whr on 2023-07-19
 */
public class ThreadLocalDemo {

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30), new ThreadPoolExecutor.AbortPolicy());

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        IntStream.range(0, 3).forEach(i -> threadPoolExecutor.execute(() -> {
            Integer value = threadLocal.get();
            System.out.println("Thread-" + i + " :" + value);
            threadLocal.set(value + 1);
        }));
        threadPoolExecutor.shutdown();
    }
}
