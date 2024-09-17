package com.xiaohan.demo.basic.custompool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // 初始化自定义线程池
        CustomThreadPool customThreadPool = new CustomThreadPool(5, 10);

        // 执行任务
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            customThreadPool.execute(() -> {
                list.add(random.nextInt());
            });
        }

        // 停止线程池
        customThreadPool.shutDown();

        System.out.println(list.size());
        long end = System.currentTimeMillis();
        System.out.println("time cost: " + (end - start));
    }
}
