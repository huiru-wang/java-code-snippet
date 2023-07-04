package com.snippet.algo.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * create by whr on 2023-04-09
 */
public class Q2_6_PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode point = head;
        List<Integer> records = new ArrayList<>();
        while (head != null && head.next != null) {
            head = head.next.next;
            records.add(point.val);
            point = point.next;
        }
        int index = records.size() - 1;
        if (head != null) {
            point = point.next;
        }
        while (point != null) {
            if (point.val != records.get(index--)) {
                return false;
            }
            point = point.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        isPalindrome(head);
    }
}
