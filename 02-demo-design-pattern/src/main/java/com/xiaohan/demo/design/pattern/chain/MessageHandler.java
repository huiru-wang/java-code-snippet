package com.xiaohan.demo.design.pattern.chain;

public interface MessageHandler {

    int order();

    void handle(Message message);
}
