package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-09
 */
public class Q2_2_KthNodeFromEndOfList {
    public int kthToLast(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        head = dummy.next;
        while (count-- != k) {
            head = head.next;
        }
        return head.val;
    }
}
