package com.xiaohan.demo.design.pattern.strategy.combination.concrete;


import com.xiaohan.demo.design.pattern.strategy.Order;
import com.xiaohan.demo.design.pattern.strategy.PaymentStrategy;

public class AdyenPayment implements PaymentStrategy {
    @Override
    public boolean payment(Order order) {
        System.out.println("Adyen payment " + order.getAmount());
        return true;
    }
}