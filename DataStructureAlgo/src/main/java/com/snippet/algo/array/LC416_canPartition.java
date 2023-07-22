package com.snippet.algo.array;

import java.util.Arrays;

/**
 * create by whr on 2023-07-22
 */
public class LC416_canPartition {

    boolean isDone = false;

    public boolean canPartition(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        dfs(nums, 0, 0, sum / 2);
        return isDone;
    }

    private void dfs(int[] nums, int sum, int start, int target) {
        if (isDone) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) {
                isDone = true;
                return;
            }
            if (sum > target) {
                return;
            }
            dfs(nums, sum, i + 1, target);
            sum -= nums[i];
        }
    }

    public static void main(String[] args) {
        
    }
}
