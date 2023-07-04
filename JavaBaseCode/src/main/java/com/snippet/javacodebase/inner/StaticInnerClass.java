package com.snippet.javacodebase.inner;

/**
 * 静态内部类
 * create by whr on 2023-06-17
 */
public class StaticInnerClass {

    // 相当于外部类的静态变量
    public static class MyInnerClass {
        private String field1;
        private static String field2;
    }

    public static void main(String[] args) {

        System.out.println(MyInnerClass.field2);
        
        System.out.println(new MyInnerClass().field1);
    }
}
