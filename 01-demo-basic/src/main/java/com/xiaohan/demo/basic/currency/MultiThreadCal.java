package com.xiaohan.demo.basic.currency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 分发任务给子线程，最终汇总
 * <pre>
 * 1. 主线程阻塞等待所有子线程，然后汇总
 * 2. 子线程将计算结果，发送到队列，主线程消费队列，实时汇总；
 * </pre>
 */
public class MultiThreadCal implements Callable<Integer> {

    private final int start;

    private final int end;

    public MultiThreadCal(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("Sub Task For ["+ start+ "," + end+ "] Sum: [" + sum + "]");
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                10, 10L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );

        int interval = 100 / 10;
        List<Callable<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int start = i * interval + 1;
            int end = (i + 1) * interval;
            // 分发子任务
            MultiThreadCal task = new MultiThreadCal(start, end);
            list.add(task);
        }
        // 子任务启动
        List<Future<Integer>> futures = executor.invokeAll(list, 60L, TimeUnit.SECONDS);

        // 获取子任务结果,汇总
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = futures.get(i);
            sum += future.get();
        }
        System.out.println("Main Task Got Sum: [" + sum + "]");
        executor.shutdown();

        int res = 0;
        for (int i = 0; i <= 100; i++) {
            res += i;
        }
        System.out.println(res);
    }
}
