package com.xiaohan.leetcode.dp;

public class no_55_jump_game {

    /**
     * Greedy
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i <= reach; i++) {
            if (nums[i] + i > reach) {
                reach = nums[i] + i;
            }
            if (reach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * DP 实现
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */

}
