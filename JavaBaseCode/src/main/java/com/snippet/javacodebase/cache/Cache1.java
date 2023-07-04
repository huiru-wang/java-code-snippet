package com.snippet.javacodebase.cache;

/**
 * 缓存行不填充
 * create by whr on 2023-06-16
 */
public class Cache1 {

    private static class Entity {
        public volatile long x = 1L;
    }

    public static Entity[] arr = new Entity[2];

    static {
        arr[0] = new Entity();
        arr[1] = new Entity();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) {
                arr[0].x = i;
            }
        }, "ThreadA");

        Thread threadB = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) {
                arr[1].x = i;
            }
        }, "ThreadB");

        final long start = System.nanoTime();
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        final long end = System.nanoTime();
        System.out.println("耗时：" + (end - start) / 100_0000);

    }
}
