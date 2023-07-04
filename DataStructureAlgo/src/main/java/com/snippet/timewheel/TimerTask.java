package com.snippet.timewheel;

import lombok.Data;

/**
 * 实际定时任务 每个节点带有一个TimerTask
 * <p>
 * create by whr on 2023-06-29
 */
@Data
public class TimerTask implements Runnable {

    private Long delayMs;

    private TimerTaskEntry timerTaskEntry;

    private String name;

    public TimerTask(String name, long delayMs) {
        this.name = name;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {

    }
}
