package com.snippet.algo.monotonicity;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * create by whr on 2023/3/23
 */
public class LC_739_DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answers = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            answers[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answers;
    }

    public int[] dailyTemperaturesII(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer index = stack.pop();
                temperatures[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            temperatures[stack.pop()] = 0;
        }
        return temperatures;
    }
}