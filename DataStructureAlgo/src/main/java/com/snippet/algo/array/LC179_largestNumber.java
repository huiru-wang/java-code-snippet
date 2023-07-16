package com.snippet.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个数排序，相加后哪个最大，谁就在前面
 * create by whr on 2023-07-04
 */
public class LC179_largestNumber {

    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        // 两个数排序，相加后哪个最大，谁就在前面: "91" + "71" 最大是"9171",所以"91"在前
        list.sort((a, b) -> (b + a).compareTo(a + b));
        if ("0".equals(list.get(0))) {
            return "0";
        }
        return String.join("", list);
    }

    public static void main(String[] args) {
        String s = largestNumber(new int[]{3, 30, 34, 5, 9});
    }
}