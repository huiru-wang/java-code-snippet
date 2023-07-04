package com.snippet.algo.slidingwindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * create by whr on 2023/3/21
 */
public class LC_209_MinimumSizeSubArray {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = nums[left], minLen = Integer.MAX_VALUE;
        while (left < nums.length) {
            if (sum >= target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                sum -= nums[left];
                left++;
            } else if (right < nums.length - 1) {
                sum += nums[++right];
            } else {
                break;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 7};
        int res = minSubArrayLen(7, nums);
        System.out.println(res);
    }
}
