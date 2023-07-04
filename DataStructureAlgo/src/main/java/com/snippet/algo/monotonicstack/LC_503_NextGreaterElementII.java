package com.snippet.algo.monotonicstack;

import java.util.Stack;

/**
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 * 循环数组，输入的索引进行翻倍，再取余，可以模拟双倍长度，遍历两次
 * <p>
 * create by whr on 2023/3/23
 */
public class LC_503_NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        // 模拟双倍长度，遍历两次
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % len] >= stack.peek()) { // 相等需要pop 可能是自己本身
                stack.pop();
            }
            result[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int[] ints = nextGreaterElements(nums);
    }
}
