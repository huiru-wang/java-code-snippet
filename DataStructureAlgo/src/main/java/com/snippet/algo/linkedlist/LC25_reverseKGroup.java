package com.snippet.algo.linkedlist;

/**
 * create by whr on 2023-07-02
 */
public class LC25_reverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        ListNode dummy = root;
        int count = 0;
        ListNode pre = head;
        while (head != null) {
            count++;
            if (count == k) {
                // reverse
                ListNode cur = head.next;
                ListNode end = pre;
                while (count > 0) {
                    ListNode next = pre.next;
                    pre.next = cur;
                    cur = pre;
                    pre = next;
                    count--;
                }
                head = end;
                count = 0;
                root.next = cur;
                root = end;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, null);
        ListNode listNode1 = reverseKGroup(listNode, 1);
    }
}
