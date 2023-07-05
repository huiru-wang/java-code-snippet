package com.snippet.designpattern.chain;

public interface MessageHandler {

    int order();

    void handle(Message message);
}
