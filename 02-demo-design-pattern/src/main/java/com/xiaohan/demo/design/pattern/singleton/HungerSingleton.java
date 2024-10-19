package com.xiaohan.demo.design.pattern.singleton;

/**
 * 依赖于JVM的类加载的线程安全
 * 非懒加载
 * <p>
 * create by whr on 2023/3/4
 */
public class HungerSingleton {
    private HungerSingleton() {
    }

    private static final HungerSingleton instance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return instance;
    }
}
