package com.xiaohan.demo.basic.reflect;

/**
 * <pre>
 * 对比3种方式通过反射获取类的性能
 * Class.forName 是最慢的
 * </pre>
 *
 * <pre>
 * 如何提高反射性能；
 * 1. 禁用代码检查，设置为true即可：method.setAccessible(true);
 * 2. 反射的主要耗时在获取class对象上，可以根据业务场景适当进行缓存
 * </pre>
 *
 */
public class ReflectDemo {

    static class Tool {
        public void doSomething() {
            // ...
        }
    }

    private void testReflect1() {
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            Class<Tool> toolClass = Tool.class;
        }
        System.out.println(System.nanoTime() - start); // 11_931_100
    }

    private void testReflect2() {
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            Class<? extends Tool> toolClass = new Tool().getClass();
        }
        System.out.println(System.nanoTime() - start); // 9_278_800
    }

    private void testReflect3() throws ClassNotFoundException {
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            Class<?> toolClass = Class.forName("com.snippet.javacodebase.ReflectTest$Tool");
        }
        System.out.println(System.nanoTime() - start); // 105_756_500
    }


}
