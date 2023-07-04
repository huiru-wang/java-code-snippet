package com.snippet.javacodebase.inner;

/**
 * create by whr on 2023-06-17
 */
public class InnerClass {

    // 相当于外部类的成员变量
    public class MyInnerClass {
        public String field1;

        // java 16后可以创建静态变量
        public static String field2;
    }


    public static void main(String[] args) {

        System.out.println(MyInnerClass.field2);

        InnerClass innerClass = new InnerClass();
        MyInnerClass myInnerClass = innerClass.new MyInnerClass();
        System.out.println();
    }

}
