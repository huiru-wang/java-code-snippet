package com.xiaohan.demo.design.pattern.decorator;

public class ByteReader implements Reader {
    @Override
    public void read(String filename) {
        System.out.println("read from" + filename + " as bytes");
    }
}
