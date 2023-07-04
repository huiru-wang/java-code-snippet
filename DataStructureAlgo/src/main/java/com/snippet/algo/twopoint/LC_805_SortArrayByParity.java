package com.snippet.algo.twopoint;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 * No order required in both two part.
 * <p>
 * create by whr on 2023/3/26
 */
public class LC_805_SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                answer[left++] = nums[i];
            } else {
                answer[right--] = nums[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
    }
}
