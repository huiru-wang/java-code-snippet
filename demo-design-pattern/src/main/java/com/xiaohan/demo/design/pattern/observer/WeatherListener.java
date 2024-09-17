package com.xiaohan.demo.design.pattern.observer;

public interface WeatherListener {
    void onTemperatureUp(String temperature);

    void onTemperatureDown(String temperature);
}
