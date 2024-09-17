package com.xiaohan.demo.design.pattern.singleton;

/**
 * 外部类初次加载，会初始化静态变量、方法，不会加载内部类
 * 第一次调用初始化内部类，才会初始化单例对象，依赖于JVM的类加载的线程安全
 * <p>
 * create by whr on 2023/3/4
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    // 内部类来实例化 单例
    private static class SingletonHolder {

        // 懒加载 首次new会加载静态内部类，并由JVM类加载保证线程安全
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    // 获取内部类实例化的 单例对象
    public static InnerClassSingleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}
