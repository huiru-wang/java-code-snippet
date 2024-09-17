package com.xiaohan.demo.design.pattern.factory.factories;


import com.xiaohan.demo.design.pattern.factory.Ball;
import com.xiaohan.demo.design.pattern.factory.BallFactory;
import com.xiaohan.demo.design.pattern.factory.balls.BasketBall;

/**
 * create by whr on 2023-07-06
 */
public class BasketFactory implements BallFactory {

    @Override
    public Ball produce() {
        BasketBall basketBall = new BasketBall();
        System.out.println("Produce basketball");
        return basketBall;
    }
}
