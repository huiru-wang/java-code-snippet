package com.snippet.designpattern.singleton;

/**
 * 枚举单例最大的好处：可以防止反射获取实例，JVM保证；
 * 其他单例实现都无法防止反射来调用私有构造函数创建对象，破坏单例
 * <p>
 * create by whr on 2023-06-17
 */
public enum EnumSingleton {
    INSTANCE;

    public void method() {
        System.out.println("Singleton Instance Method");
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.method();
    }
}
