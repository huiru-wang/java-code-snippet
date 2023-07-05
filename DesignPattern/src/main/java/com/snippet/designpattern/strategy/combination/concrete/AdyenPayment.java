package com.snippet.designpattern.strategy.combination.concrete;

import com.snippet.designpattern.strategy.Order;
import com.snippet.designpattern.strategy.PaymentStrategy;


public class AdyenPayment implements PaymentStrategy {
    @Override
    public boolean payment(Order order) {
        System.out.println("Adyen payment " + order.getAmount());
        return true;
    }
}