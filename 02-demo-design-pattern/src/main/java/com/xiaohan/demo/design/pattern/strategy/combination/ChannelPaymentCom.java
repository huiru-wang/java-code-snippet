package com.xiaohan.demo.design.pattern.strategy.combination;


import com.xiaohan.demo.design.pattern.strategy.Order;
import com.xiaohan.demo.design.pattern.strategy.PaymentStrategy;
import com.xiaohan.demo.design.pattern.strategy.simple.concrete.AdyenPayment;

import java.util.HashMap;
import java.util.Map;

/**
 * 可以拓展为模板方法
 * 增加：
 * payment, refund, query...
 */
public class ChannelPaymentCom {

    Map<String, PaymentStrategy> paymentStrategyMap = new HashMap<>();

    {
        paymentStrategyMap.put("Adyen", new AdyenPayment());
        paymentStrategyMap.put("Knet", new AdyenPayment());
        paymentStrategyMap.put("PayPal", new AdyenPayment());
    }

    public void doPayment(Order order) {
        PaymentStrategy paymentStrategy = paymentStrategyMap.get(order.getPayType());
        paymentStrategy.payment(order);
    }
}
