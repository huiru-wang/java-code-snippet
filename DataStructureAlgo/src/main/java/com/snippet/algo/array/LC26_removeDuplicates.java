package com.snippet.algo.array;

/**
 * create by whr on 2023-06-28
 */
public class LC26_removeDuplicates {

    /**
     * 双指针 后置指针移动，直到不相同 然后覆盖前指针
     *
     * @param nums nums
     * @return int
     */
    public static int removeDuplicates(int[] nums) {
        int count = 0, point = count + 1, len = nums.length;
        while (count < len && point < len) {
            if (nums[count] == nums[point]) {
                while (point < len && nums[count] == nums[point]) {
                    point++;
                }
                if (point > len - 1) {
                    break;
                }
                nums[++count] = nums[point];
            } else {
                count++;
                point++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 2});
    }
}
