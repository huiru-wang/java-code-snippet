package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-09
 */
public class Q2_5_SumLinkedLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode pre = dummy;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            sum += carry;
            int unit = sum % 10;
            carry = sum / 10;
            if (l1 != null) {
                l1.val = unit;
            } else {
                pre.next = l2;
                l2.val = unit;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
