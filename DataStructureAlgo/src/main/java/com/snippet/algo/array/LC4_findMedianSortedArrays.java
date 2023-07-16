package com.snippet.algo.array;

/**
 * 多数组查找 倒数第k个数
 * 相当于查找排序后的中间数
 * <p>
 * create by whr on 2023-06-25
 */
public class LC4_findMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 只需要找到两个数组长度的中间位置
        int n = (nums1.length + nums2.length) / 2 + 1;
        // 新建数组，等待排序后放入
        int[] num = new int[n];
        int i = 0, j = 0;
        // 归并 放入新数组，直到数量达到n/2
        for (int k = 0; k < n; k++) {
            // 哪个小取哪个
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    num[k] = nums1[i++];
                } else {
                    num[k] = nums2[j++];
                }
            } else {
                num[k] = i < nums1.length ? nums1[i++] : nums2[j++];
            }
        }
        if (n % 2 == 0) {
            return (num[n - 1] + num[n - 2]) / 2.0;
        }
        return num[n - 1];
    }

    // 从小向大找到中间
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int i = 0, j = 0, count = 0;
        int min1 = 0, min2 = 0;
        for (int k = 0; k < n; k++) {
            int cur = 0;
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    cur = nums1[i];
                    i++;
                } else {
                    cur = nums2[j];
                    j++;
                }
            } else {
                if (i >= nums1.length) {
                    cur = nums1[j];
                    j++;
                } else {
                    cur = nums1[i];
                    i++;
                }
            }
            if (count == n / 2 - 1) {
                min1 = cur;
            }
            if (count == n / 2) {
                min2 = cur;
                break;
            }
            count++;
        }
        return n % 2 == 0 ? (min1 + min2) / 2.0 : min2 / 2.0;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }


}
