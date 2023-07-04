package com.snippet.algo.lcci;

/**
 * create by whr on 2023/3/23
 */
public class Q1_1_IsUnique {

    public boolean isUnique(String astr) {
        int[] bits = new int[58];
        char[] chars = astr.toCharArray();
        for (char c : chars) {
            if (bits[c - 'a'] != 0) {
                return false;
            }
            bits[c-'a']++;
        }
        return true;
    }
    public boolean isUnique1(String astr) {
        int[] bits = new int[58];
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (bits[c- 'a'] != 0) {
                return false;
            }
            bits[c-'a']++;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
