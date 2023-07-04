package com.snippet.algo.slidingwindow;

import java.util.Arrays;

/**
 * return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * create by whr on 2023/3/22
 */
public class LC_567_PermutationInString {

    // 1. 固定窗口，每次拿窗口字符去验证，成功则返回true，失败继续；复杂度高
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int left = 0;
        int[] bitArray = generateBitArray(s1);
        int charsCount = s1.length();
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            if (!s1.contains(s2.substring(i, i + 1))) {
                left++;
                continue;
            }
            String curChar = s2.substring(left, i + 1);
            if (containsPermutation(Arrays.copyOf(bitArray, bitArray.length), charsCount, curChar)) {
                return true;
            }
            left++;
        }

        return false;
    }

    private static int[] generateBitArray(String target) {
        int[] bitArray = new int[26];
        char[] chars = target.toCharArray();
        for (char c : chars) {
            bitArray[c - 'a']++;
        }
        return bitArray;
    }

    private static boolean containsPermutation(int[] strBit, int charsCount, String target) {
        char[] chars = target.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (strBit[index] > 0) {
                strBit[index]--;
                charsCount--;
            } else {
                return false;
            }
        }
        return charsCount == 0;
    }

    // 2.

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }
}
