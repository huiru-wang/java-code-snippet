package com.xiaohan.leetcode.array;

public class no_26_remove_duplicates {

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int uniqueIndex = 0;
        // j遍历完成数组
        for (int j = 1; j < nums.length; j++) {
            if (nums[uniqueIndex] != nums[j]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[j];
            }
        }
        return uniqueIndex + 1;
    }
}
