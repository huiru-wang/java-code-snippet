package com.snippet.algo.strings;

/**
 * TODO
 * create by whr on 2023-07-17
 */
public class LC1234_balancedString {


    public static int balancedString(String s) {
        int[] bitmap = new int['W' - 'E' + 1];
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0, end = len - 1;
        while (start < len && bitmap[chars[start] - 'E'] < len / 4) {
            bitmap[chars[start] - 'E']++;
            start++;
        }
        while (end > start && bitmap[chars[end] - 'E'] <= len / 4) {
            bitmap[chars[end] - 'E']++;
            end--;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println("WWEQERQWQW WRWW ERQWEQ".length());
        int qqwe = balancedString("QQQW");
    }
}
