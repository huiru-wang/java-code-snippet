package com.snippet.algo.monotonicity;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * create by whr on 2023/3/22
 */
public class LC_496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
//        int[] nextGreater = new int[nums2.length];
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
//            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            nextGreaterMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreaterMap.get(nums1[i]);
        }
        return res;
    }
}
