package com.xiaohan.demo.design.pattern.factory.factories;

import com.xiaohan.demo.design.pattern.factory.Ball;
import com.xiaohan.demo.design.pattern.factory.BallFactory;
import com.xiaohan.demo.design.pattern.factory.balls.FootBall;

/**
 * create by whr on 2023-07-06
 */
public class FootFactory implements BallFactory {

    @Override
    public Ball produce() {
        FootBall footBall = new FootBall();
        System.out.println("Produce football");
        return footBall;
    }
}
