package com.snippet.algo.linkedlist;

/**
 * create by whr on 2023-07-02
 */
public class LC876_middleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
