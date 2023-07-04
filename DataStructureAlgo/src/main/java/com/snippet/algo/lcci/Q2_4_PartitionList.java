package com.snippet.algo.lcci;

/**
 * [dummy-leftPartition]-[rightPartition]-[leftPartition]
 * <p>
 * create by whr on 2023-04-09
 */
public class Q2_4_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPartition = dummy;
        while (head != null && head.val < x) {
            leftPartition = head;
            head = head.next;
        }
        ListNode rightPointEnd = new ListNode(0);
        while (head != null) {
            if (head.val < x) {
                ListNode temp = head;
                ListNode leftPointEnd = new ListNode(0);
                while (head != null && head.val < x) {
                    leftPointEnd = head;
                    head = head.next;
                }
                leftPointEnd.next = leftPartition.next;
                leftPartition.next = temp;
                rightPointEnd.next = head;
                leftPartition = leftPointEnd;
            } else {
                rightPointEnd = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
