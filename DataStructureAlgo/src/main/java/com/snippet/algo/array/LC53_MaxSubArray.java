package com.snippet.algo.array;

/**
 * 最大连续子数组
 * <p>
 * create by whr on 2023-06-30
 */
public class LC53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 前一个大于0 才会使得当前最大值是增加的
            if (nums[i - 1] > 0) {
                // 将i的当前值更新为 截止到i的最大数组和
                nums[i] += nums[i - 1];
            }
            // 刷新最大值
            if (nums[i] > sum) {
                sum = nums[i];
            }
        }
        return sum;
    }
}
