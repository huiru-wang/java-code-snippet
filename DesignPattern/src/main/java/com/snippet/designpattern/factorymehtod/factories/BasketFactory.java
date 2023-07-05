package com.snippet.designpattern.factorymehtod.factories;

import com.snippet.designpattern.factorymehtod.Ball;
import com.snippet.designpattern.factorymehtod.BallFactory;
import com.snippet.designpattern.factorymehtod.balls.BasketBall;

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
