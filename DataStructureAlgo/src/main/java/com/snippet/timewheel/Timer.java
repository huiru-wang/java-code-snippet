package com.snippet.timewheel;

// https://juejin.cn/post/7083795682313633822
public interface Timer {

    void add(TimerTask timerTask);

    void advanceClock(long timeout);
}
