package com.xiaohan.demo.design.pattern.observer.listeners;


import com.xiaohan.demo.design.pattern.observer.WeatherListener;

public class GrandMa implements WeatherListener {

    @Override
    public void onTemperatureUp(String temperature) {
        // 接收通知
        System.out.println("GrandMa get the temperature rise up message");
    }

    @Override
    public void onTemperatureDown(String temperature) {
        // 接收通知
        System.out.println("GrandMa get the temperature cool donw message");
    }

}
