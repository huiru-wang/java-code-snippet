package com.xiaohan.demo.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CompletableFuture;

public class Weather {

    private static final List<WeatherListener> listeners;


    // 订阅实现：1. SPI注入：在META-INF/services下 增加接口的实现类
    static {
        ServiceLoader<WeatherListener> weatherListeners = ServiceLoader.load(WeatherListener.class);
        listeners = new ArrayList<>();
        for (WeatherListener weatherListener : weatherListeners) {
            listeners.add(weatherListener);
        }
    }

    // 订阅实现：2. 手动订阅
    public void addSubscriber(WeatherListener weatherListener) {
        listeners.add(weatherListener);
    }

    public void riseUp(String temperature) {
        System.out.println("weather is rise up:" + temperature);

        // 异步发布消息
        for (WeatherListener listener : listeners) {
            CompletableFuture.runAsync(() -> {
                listener.onTemperatureUp(temperature);
            });
        }
    }

    public void coolDown(String temperature) {
        System.out.println("weather is cool down:" + temperature);

        // 同步发布消息
        listeners.forEach(listener -> listener.onTemperatureDown(temperature));
    }

}
