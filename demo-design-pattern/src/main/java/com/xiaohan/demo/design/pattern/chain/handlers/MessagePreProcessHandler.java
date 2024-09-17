package com.xiaohan.demo.design.pattern.chain.handlers;

import com.xiaohan.demo.design.pattern.chain.Message;
import com.xiaohan.demo.design.pattern.chain.MessageHandler;

/**
 * create by whr on 2023-07-05
 */
public class MessagePreProcessHandler implements MessageHandler {


    @Override
    public int order() {
        return -1;
    }

    @Override
    public void handle(Message message) {
        message.setStatus("Init");
        System.out.println("Message Init Done");
    }
}
