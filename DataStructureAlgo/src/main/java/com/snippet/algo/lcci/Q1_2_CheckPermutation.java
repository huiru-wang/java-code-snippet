package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-05
 */
public class Q1_2_CheckPermutation {

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] bits = new int[58];
        for (int i = 0; i < s1.length(); i++) {
            bits[s1.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            if (bits[index] > 0) {
                count++;
                bits[index]--;
            }
        }
        return count == s1.length();
    }

    public static void main(String[] args) {
        checkPermutation("a", "abca");
    }
}
