package com.snippet.designpattern.strategy.simple.concrete;

import com.snippet.designpattern.strategy.Order;
import com.snippet.designpattern.strategy.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public boolean payment(Order order) {
        System.out.println("PayPal Pay");
        return true;
    }
}
