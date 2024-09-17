package com.xiaohan.demo.design.pattern.factory.factories;

import com.snippet.designpattern.factorymehtod.Ball;
import com.snippet.designpattern.factorymehtod.BallFactory;
import com.snippet.designpattern.factorymehtod.balls.FootBall;

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
