package com.snippet.algo.strings;

import java.util.Arrays;

/**
 * 双指针 滑动窗口
 * create by whr on 2023-07-01
 */
public class LC3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] bitmap = new int[255];
        Arrays.fill(bitmap, -1);
        int max = 0, left = 0, right = 0, len = s.length();
        // 保持[left,right]是不重复的 不断更新max，重复则调整left
        while (right < len) {
            char curChar = s.charAt(right);
            int bit = bitmap[curChar];
            left = Math.max(bit + 1, left); // 重复字符的后一位，但不能小于上次记录点
            max = Math.max(max, right - left + 1); // 每次更新当前值
            bitmap[curChar] = right;
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(' ' - '0');
    }
}
