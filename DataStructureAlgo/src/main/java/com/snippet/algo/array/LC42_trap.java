package com.snippet.algo.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 高度在逐步降低的时候，是接不了水的，当出现升高，说明可以接住雨水
 * 因此：单调栈
 * <p>
 * create by whr on 2023-06-25
 */
public class LC42_trap {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int left = 0, area = 0;
        while (height[left] == 0) {
            left++;
        }
        while (left < height.length) {
            while (!stack.isEmpty() && stack.peek() < height[left]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(left++);
                continue;
            }
            Integer pop = stack.pop();


        }

        return 0;
    }
}
