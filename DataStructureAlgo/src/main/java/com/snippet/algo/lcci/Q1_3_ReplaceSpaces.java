package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-05
 */
public class Q1_3_ReplaceSpaces {
    public String replaceSpaces(String s, int length) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == length) {
                break;
            }
            if (s.charAt(i) == 32) {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
            count++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
