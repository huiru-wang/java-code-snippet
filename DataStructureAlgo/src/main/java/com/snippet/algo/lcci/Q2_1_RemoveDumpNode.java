package com.snippet.algo.lcci;


import java.util.HashSet;
import java.util.Set;

/**
 * [1, 2, 3, 3, 2, 1]
 * 非升序的链表，需要记录已经存在的值，多一个Set的空间
 * <p>
 * create by whr on 2023-04-09
 */
public class Q2_1_RemoveDumpNode {
    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) {
            set.add(head.val);
            ListNode next = head.next;
            while (next != null && set.contains(next.val)) {
                next = next.next;
            }
            head.next = next;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        removeDuplicateNodes(head);
    }
}
