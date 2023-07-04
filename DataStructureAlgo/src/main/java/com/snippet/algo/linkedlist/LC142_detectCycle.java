package com.snippet.algo.linkedlist;

/**
 * create by whr on 2023-07-02
 */
public class LC142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 判断是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 有环则break
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // 无环
            return null;
        }
        // 从相遇点和起始点 同时出发 再次相交则为相交点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
