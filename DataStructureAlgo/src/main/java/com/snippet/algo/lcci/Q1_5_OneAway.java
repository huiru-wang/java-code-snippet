package com.snippet.algo.lcci;

import java.util.HashMap;
import java.util.Map;

/**
 * create by whr on 2023-04-05
 */
public class Q1_5_OneAway {
    public static boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int longer = first.length();
        int shorter = second.length();
        if (shorter == 0) {
            return true;
        }
        int count = 0;
        int point = 0;
        if (shorter + 1 == longer || longer == shorter) {
            for (int i = 0; i < longer; i++) {
                if (first.charAt(i) != second.charAt(point)) {
                    count++;
                    if (longer == shorter) {
                        point++;
                    }
                    continue;
                }
                point++;
                if (point == shorter || count > 1) {
                    break;
                }
            }
            return count == 1 || (count == 0 && point == shorter);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = oneEditAway("a", "a");
    }
}
