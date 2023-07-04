package com.snippet.algo.array;

/**
 * create by whr on 2023-06-30
 */
public class JZ3_findRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int[] bitmap = new int[(int) 10E5];
        for (int num : nums) {
            if (bitmap[num] > 0) {
                return num;
            }
            bitmap[num]++;
        }
        return -1;
    }
}
