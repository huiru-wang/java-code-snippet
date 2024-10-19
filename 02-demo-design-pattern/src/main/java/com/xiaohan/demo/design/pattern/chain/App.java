package com.xiaohan.demo.design.pattern.chain;

import com.xiaohan.demo.design.pattern.chain.handlers.MessageConvertHandler;
import com.xiaohan.demo.design.pattern.chain.handlers.MessagePreProcessHandler;
import com.xiaohan.demo.design.pattern.chain.handlers.MessageResultHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * create by whr on 2023-07-05
 */
public class App {
    public static void main(String[] args) {
        List<MessageHandler> messageHandlers = new ArrayList<>();
        messageHandlers.add(new MessagePreProcessHandler());
        messageHandlers.add(new MessageConvertHandler());
        messageHandlers.add(new MessageResultHandler());
        messageHandlers.sort(Comparator.comparing(MessageHandler::order));

        Message message = new Message();

        messageHandlers.forEach(messageHandler -> messageHandler.handle(message));
    }
}
