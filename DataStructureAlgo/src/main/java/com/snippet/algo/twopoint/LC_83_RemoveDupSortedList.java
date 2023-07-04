package com.snippet.algo.twopoint;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 * create by whr on 2023/3/26
 */
public class LC_83_RemoveDupSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (head != null) {
            ListNode curNode = head;
            while (curNode.next != null && curNode.val == curNode.next.val) {
                curNode = curNode.next;
            }
            head.next = curNode.next;
            head = head.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode res = deleteDuplicates(listNode);
    }
}
