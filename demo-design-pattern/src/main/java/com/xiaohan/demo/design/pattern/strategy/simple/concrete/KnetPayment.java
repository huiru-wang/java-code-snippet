package com.xiaohan.demo.design.pattern.strategy.simple.concrete;

import com.snippet.designpattern.strategy.Order;
import com.snippet.designpattern.strategy.PaymentStrategy;

public class KnetPayment implements PaymentStrategy {
    @Override
    public boolean payment(Order order) {
        System.out.println("Knet Pay");
        return true;
    }
}
