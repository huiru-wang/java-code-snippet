package com.xiaohan.demo.design.pattern.factory;

/**
 * create by whr on 2023-07-06
 */
public class App {
    public static void main(String[] args) {
        BallFactory basketBallFactory = BallFactoryGenerator.getFactory(BallTypeEnum.BASKETBALL);
        Ball produce = basketBallFactory.produce();
    }
}
