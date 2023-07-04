package com.snippet.algo.linkedlist;


/**
 * create by whr on 2023-06-25
 */
public class LC_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = (a + b + flag) % 10;
            flag = (a + b + flag) / 10;
            head.next = new ListNode(sum);
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (flag != 0) {
            head.next = new ListNode(1);
        }
        return res.next;
    }
}
