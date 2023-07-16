package com.snippet.sort;

import java.util.Arrays;

/**
 * create by whr on 2023-07-02
 */
public class QuickSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int mid = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= mid) {
                j--;
            }
            while (i < j && nums[i] <= mid) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 5, 9};
        new QuickSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
