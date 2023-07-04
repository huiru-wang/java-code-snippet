package com.snippet.algo.lcci;

import java.util.HashMap;
import java.util.Map;

/**
 * create by whr on 2023-04-05
 */
public class Q1_4_CanPermutePalindrome {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.remove(c);
            }
        }
        return map.size() == 1 || map.size() == 0;
    }
}
