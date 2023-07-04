package com.snippet.algo.array;

/**
 * create by whr on 2023-06-29
 */
public class LC27_removeElement {

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0 || (len == 1 && nums[0] == val)) {
            return 0;
        }
        int left;
        for (left = 0; left < len - 1; left++) {
            if (nums[left] != val) {
                continue;
            }
            int right = left + 1;
            while (right < len && nums[right] == val) {
                right++;
            }
            if (right >= len) {
                break;
            }
            nums[left] = nums[right];
            nums[right] = val;
        }
        return left;
    }

    public static void main(String[] args) {
        int i = removeElement(new int[]{2}, 3);
    }
}
