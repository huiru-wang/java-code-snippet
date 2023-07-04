package com.snippet.algo.twopoint;

/**
 * create by whr on 2023/3/26
 */
public class LC_283_MoveZeros {

    public static void moveZeroes(int[] nums) {
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                right++;
                continue;
            }
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (right == nums.length) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[right];
            nums[right] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(nums);
    }
}
