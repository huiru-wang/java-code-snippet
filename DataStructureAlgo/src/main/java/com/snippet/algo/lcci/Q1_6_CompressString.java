package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-06
 */
public class Q1_6_CompressString {
    public String compressString(String s) {
        int length = s.length();
        if (length < 3) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int left = 0, right = 1;
        while (left < length || right < length) {
            int count = 1;
            char c = s.charAt(left);
            while (right < length && c == s.charAt(right)) {
                right++;
                count++;
            }
            res.append(c).append(count);
            left = right;
            right = left + 1;
        }
        return res.length() > length ? s : res.toString();
    }
}
