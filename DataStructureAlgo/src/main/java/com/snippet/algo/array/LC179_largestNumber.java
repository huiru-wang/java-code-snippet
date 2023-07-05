package com.snippet.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * create by whr on 2023-07-04
 */
public class LC179_largestNumber {

    // TODO
    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
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