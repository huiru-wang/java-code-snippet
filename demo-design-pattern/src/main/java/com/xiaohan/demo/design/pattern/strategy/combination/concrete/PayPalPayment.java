package com.xiaohan.demo.design.pattern.strategy.combination.concrete;

import com.snippet.designpattern.strategy.Order;
import com.snippet.designpattern.strategy.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public boolean payment(Order order) {
        System.out.println("PayPal payment " + order.getAmount());
        return true;
    }
}
