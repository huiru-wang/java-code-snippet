package com.xiaohan.demo.design.pattern.strategy.simple;


import com.xiaohan.demo.design.pattern.strategy.Order;
import com.xiaohan.demo.design.pattern.strategy.PaymentStrategy;

public class ChannelPayment {

    private PaymentStrategy paymentStrategy;

    public ChannelPayment(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void doPayment(Order order) {
        System.out.println("Do Payment");
        this.paymentStrategy.payment(order);
    }
}
