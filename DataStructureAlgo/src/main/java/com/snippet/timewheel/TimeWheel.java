package com.snippet.timewheel;

import java.util.concurrent.DelayQueue;

/**
 * 时间轮
 * <p>
 * create by whr on 2023-06-29
 */
public class TimeWheel {

    private Long tickMs;

    private int wheelSize;

    private Long interval;

    private Long currentTime;

    private TimerTaskList[] buckets;

    // 上层轮 每超过一个周期 生成上一层轮
    // 当前轮用完走上一层轮 当前轮抛弃
    private volatile TimeWheel superTimeWheel;

    private DelayQueue<TimerTaskList> delayQueue = new DelayQueue<>();

    public TimeWheel(Long tickMs, int wheelSize, Long currentTime, DelayQueue<TimerTaskList> delayQueue) {
        this.tickMs = tickMs;
        this.wheelSize = wheelSize;
        this.interval = tickMs * wheelSize;
        this.currentTime = currentTime;
        this.delayQueue = delayQueue;
        this.buckets = new TimerTaskList[wheelSize];
        for (int i = 0; i < this.wheelSize; i++) {
            this.buckets[i] = new TimerTaskList();
        }
    }

    /**
     * 向时间轮添加定时任务
     *
     * @param entry entry
     * @return boolean
     */
    public boolean add(TimerTaskEntry entry) {
        Long expireMs = entry.getExpireMs();
        if (expireMs < tickMs + currentTime) {
            // 直接到期 立即执行？？
            return false;
        }
        if (expireMs < interval + currentTime) {
            // 当前轮次

        } else {
            // 后续轮次或上一层轮 直接仍？？？？？ expireMs是不是应该减去一个周期
            TimeWheel timeWheel = getSuperTimeWheel();
            timeWheel.add(entry);
        }
        return false;
    }

    private TimeWheel getSuperTimeWheel() {
        if (superTimeWheel == null) {
            synchronized (this) {
                if (superTimeWheel == null) {
                    superTimeWheel = new TimeWheel(interval, wheelSize, currentTime, delayQueue);
                }
            }
        }
        return superTimeWheel;
    }
}
