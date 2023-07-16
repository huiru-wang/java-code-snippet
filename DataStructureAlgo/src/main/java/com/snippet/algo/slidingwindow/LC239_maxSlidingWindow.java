package com.snippet.algo.slidingwindow;

import java.util.PriorityQueue;

/**
 * 需要保存窗口内的一个排序，当最大的移除，要快速找到第二大的，而不能再次遍历一遍窗口<p>
 * 1. 堆<p>
 * 2. 单调队列(双端)：类似于单调栈，但是这里需要获取同时获取最大值，并从尾部添加最小值；<p>
 * <p>
 * create by whr on 2023-07-08
 */
public class LC239_maxSlidingWindow {
    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    // 排序队列记录索引
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(new Tuple(nums[i], i));
            if (i < k - 1) {
                continue;
            }
            // 从大到小，丢弃队列中已经超出窗口的值
            while (!priorityQueue.isEmpty() && priorityQueue.peek().index < (i - k + 1)) {
                priorityQueue.remove();
            }
            // 未超出窗口的最大值，记录赋值
            Tuple peek = priorityQueue.peek();
            ans[i - k + 1] = peek.val;
        }
        return ans;
    }
}

class Tuple {
    int val;

    int index;

    public Tuple(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
