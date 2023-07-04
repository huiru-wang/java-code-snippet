package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-06
 */
public class Q1_9_StringRotation {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).contains(s1);
    }
}
