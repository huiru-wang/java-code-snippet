package com.snippet.algo.strings;

/**
 * 最长回文字串
 * 回文串的可能：aba, abba
 * <p>
 * create by whr on 2023-07-01
 */
public class LC5_LongestPalindrome {

    public static String longestPalindrome(String s) {
        int left = 0, right = 1, len = s.length();
        String ans = s.substring(0, 1);
        while (right < len) {
            // 偶数情况
            if (s.charAt(left) == s.charAt(right)) {
                ans = longest(s, ans, left, right);
            }
            // 奇数情况
            if (left > 0 && s.charAt(left - 1) == s.charAt(right)) {
                ans = longest(s, ans, left - 1, right);
            }
            left++;
            right++;
        }
        return ans;
    }

    private static String longest(String s, String ans, int start, int end) {
        int len = s.length();
        while (start >= 0 && end < len) {
            if (s.charAt(start) == s.charAt(end)) {
                if (start == 0 || end == len - 1) {
                    break;
                }
                start--;
                end++;
            } else {
                start++;
                end--;
                break;
            }
        }
        String longest = s.substring(Math.max(start, 0), Math.min(end + 1, len));
        if (longest.length() > ans.length()) {
            ans = longest;
        }
        return ans;
    }

    public static void main(String[] args) {
        String cbbd = longestPalindrome("aaaa");
        System.out.println(cbbd);
    }
}
