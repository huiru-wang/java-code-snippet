package com.snippet.algo.linkedlist;

/**
 * create by whr on 2023-07-01
 */
public class LC21_mergeTwoLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (list1 != null || list2 != null) {
            if (list1 == null || list2 == null) {
                head.next = list1 == null ? list2 : list1;
                break;
            }
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        mergeTwoLists(list1, list2);
    }
}