package com.snippet.algo.linkedlist;

/**
 * create by whr on 2023-07-02
 */
public class LC206_reverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
