package com.snippet.timewheel;

import lombok.Data;

/**
 * 时间轮每个槽的链表上的节点对象
 * <p>
 * create by whr on 2023-06-29
 */
@Data
public class TimerTaskEntry implements Comparable<TimerTaskEntry> {

    volatile TimerTaskList timerTaskList;
    TimerTaskEntry next;
    TimerTaskEntry pre;

    private TimerTask timerTask;

    private Long expireMs;

    public TimerTaskEntry(TimerTask timerTask, long expireMs) {
        this.timerTask = timerTask;
        this.expireMs = expireMs;
        this.next = null;
        this.pre = null;
    }

    @Override
    public int compareTo(TimerTaskEntry o) {
        return (int) (this.expireMs - o.expireMs);
    }
}
