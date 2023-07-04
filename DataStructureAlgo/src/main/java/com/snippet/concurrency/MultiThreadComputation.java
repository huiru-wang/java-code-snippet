package com.snippet.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用 10个线程 执行 1-100相加
 * <p>
 * create by whr on 2023-07-02
 */
public class MultiThreadComputation implements Callable<Integer> {

    private final int start;
    private final int end;


    public MultiThreadComputation(int start, int end) {
        this.start = start;
        this.end = end;

    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        int interval = 100 / 10;
        List<Callable<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int start = i * interval + 1;
            int end = (i + 1) * interval;
            MultiThreadComputation task = new MultiThreadComputation(start, end);
            list.add(task);
        }
        List<Future<Integer>> futures = executor.invokeAll(list, 60L, TimeUnit.SECONDS);
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = futures.get(i);
            sum += future.get();
        }
        System.out.println(sum);
        executor.shutdown();

        int res = 0;
        for (int i = 0; i <= 100; i++) {
            res += i;
        }
        System.out.println(res);
    }
}
