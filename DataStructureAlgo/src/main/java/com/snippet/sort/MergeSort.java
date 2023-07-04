package com.snippet.sort;

/**
 * create by whr on 2023-07-02
 */
public class MergeSort {

    public void sort(int[] nums) {
        this.sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start == end)
            return;
        // 分割
        sort(nums, start, start + (end - start) / 2);
        sort(nums, start + (end - start) / 2 + 1, end);
        merge(nums, start, end);
    }

    public void merge(int[] nums, int start, int end) {
        // 排序
        int mid = start + (end - start) / 2;
        int p1 = start, p2 = mid + 1, p3 = start;
        int[] sorted = new int[nums.length];
        while (p1 <= mid && p2 <= end) {
            if (nums[p1] <= nums[p2]) {
                sorted[p3++] = nums[p1];
                p1++;
            } else {
                sorted[p3++] = nums[p2];
                p2++;
            }
        }
        while (p1 <= mid) {
            sorted[p3++] = nums[p1];
            p1++;
        }
        while (p2 <= end) {
            sorted[p3++] = nums[p2];
            p2++;
        }
        if (end + 1 - start >= 0) System.arraycopy(sorted, start, nums, start, end + 1 - start);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 6, 8, 3, 0};
        new MergeSort().sort(arr);

    }
}
