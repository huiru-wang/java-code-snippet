package com.snippet.algo.array;

/**
 * create by whr on 2023-06-25
 */
public class LC11_maxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            int water = 0;
            if (height[i] < height[j]) {
                water = height[i] * (j - i);
                i++;
            } else {
                water = height[j] * (j - i);
                j--;
            }
            if (water > max) {
                max = water;
            }
        }
        return max;
    }
}
