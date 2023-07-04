package com.snippet.algo.linkedlist;

/**
 * create by whr on 2023-07-02
 */
public class JZ22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
