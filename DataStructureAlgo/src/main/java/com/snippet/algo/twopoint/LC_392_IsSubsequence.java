package com.snippet.algo.twopoint;

/**
 * create by whr on 2023/3/26
 */
public class LC_392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() < 1) {
            return true;
        }
        int subIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (subIndex == s.length()) {
                return true;
            }
            if (s.substring(subIndex, subIndex + 1).equals(t.substring(i, i + 1))) {
                subIndex++;
            }
        }
        return false;
    }
}