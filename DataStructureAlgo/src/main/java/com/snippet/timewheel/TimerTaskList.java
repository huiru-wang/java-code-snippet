package com.snippet.timewheel;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 时间轮每个槽的链表
 * <p>
 * create by whr on 2023-06-29
 */
public class TimerTaskList implements Delayed {

    private TimerTaskEntry root = new TimerTaskEntry(null, -1);

    private AtomicLong expirationTime = new AtomicLong(-1L);

    {
        root.next = root;
        root.pre = root;
    }

    /**
     * 添加定时任务
     *
     * @param entry entry
     * @return boolean
     */
    public boolean add(TimerTaskEntry entry) {

        return true;
    }

    /**
     * 删除定时任务
     *
     * @param entry entry
     */
    public void remove(TimerTaskEntry entry) {
        synchronized (this) {
            // 是否存在与当前桶
            if (entry.getTimerTaskList().equals(this)) {
                entry.next.pre = entry.pre;
                entry.pre.next = entry.next;
                entry.next = null;
                entry.pre = null;
                entry.timerTaskList = null;
            }
        }
    }

    public void clear() {
        TimerTaskEntry head = root.next;
        while (!head.equals(root)) {
            remove(head);
            head = root.next;
        }
        expirationTime.set(-1L);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return Math.max(0, unit.convert(expirationTime.get() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof TimerTaskList) {
            return Long.compare(expirationTime.get(), ((TimerTaskList) o).expirationTime.get());
        }
        return 0;
    }
}
