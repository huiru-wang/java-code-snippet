package com.snippet.javacodebase.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * create by whr on 2023-07-19
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("All Thread Is Ok.");
        });

        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            try {
                System.out.println("Thread-" + i + " start.");
                TimeUnit.SECONDS.sleep(1);
                cyclicBarrier.await();

                TimeUnit.SECONDS.sleep(1);
                System.out.println("Thread-" + i + " continue.");
                cyclicBarrier.await();

                TimeUnit.SECONDS.sleep(1);
                System.out.println("Thread-" + i + " done.");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start());
    }
}
