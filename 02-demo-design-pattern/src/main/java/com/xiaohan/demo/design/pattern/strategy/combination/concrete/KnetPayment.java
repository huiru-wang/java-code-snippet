package com.xiaohan.demo.design.pattern.strategy.combination.concrete;

import com.xiaohan.demo.design.pattern.strategy.Order;
import com.xiaohan.demo.design.pattern.strategy.PaymentStrategy;

;

public class KnetPayment implements PaymentStrategy {
    @Override
    public boolean payment(Order order) {
        System.out.println("knet payment " + order.getAmount());
        return true;
    }
}
