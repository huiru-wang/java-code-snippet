package com.snippet.designpattern.singleton;

/**
 * 双重检查
 * 1、懒加载
 * 2、第一次检查：创建对象成功后，后续线程不需要再加锁获取对象
 * 3、第二次检查：前一个线程创建完成，后一个线程紧接着拿锁，需要再判断一次；
 * 4、必须使用volatile修饰；因为new不是原子操作，可能先赋值再创建，有可能外部线程获取空对象；因此必须禁止指令重排序(先创建对象再赋值)；
 * 并且保证instance的可见性，当创建成功后，使其他线程持有的instance缓存失效，重新读取主内存；
 * create by whr on 2023/3/4
 */
public class DoubleCheckLazySingleton {
    private DoubleCheckLazySingleton() {
    }

    // volatile必须加上 否则不安全
    private static volatile DoubleCheckLazySingleton instance;

    public static DoubleCheckLazySingleton getInstance() {

        if (instance == null) {
            // 如果开始有多个线程进入这里等待，需要第二次检查防止创建多次
            synchronized (DoubleCheckLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}
