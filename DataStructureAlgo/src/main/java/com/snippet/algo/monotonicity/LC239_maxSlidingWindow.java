package com.snippet.algo.monotonicity;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 需要保存窗口内的一个排序，当最大的移除，要快速找到第二大的，而不能再次遍历一遍窗口<p>
 * 1. 堆<p>
 * 2. 单调队列(双端)：类似于单调栈，但是这里需要获取同时获取最大值，并从尾部添加最小值；<p>
 * create by whr on 2023-07-08
 */
public class LC239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 对头保持为当前窗口的最大值
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 当队首索引已经超出窗口 则移除
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
