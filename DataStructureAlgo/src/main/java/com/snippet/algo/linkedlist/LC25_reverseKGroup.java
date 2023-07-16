package com.snippet.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * create by whr on 2023-07-02
 */
public class LC25_reverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        ListNode dummy = root;
        int index = 0;
        // 每次要旋转的链表段的头部
        ListNode subHead = head;
        while (head != null) {
            index++;
            if (index == k) {
                ListNode pre = head.next;
                ListNode end = subHead; //  提前记录新链尾部
                while (index > 0) {
                    ListNode next = subHead.next;
                    subHead.next = pre;
                    pre = subHead;
                    subHead = next;
                    index--;
                }
                // 旋转结束，pre为新链头部，end为新链尾部
                root.next = pre;    // 连接新链的头部，尾部在旋转过程中已经连接了
                head = end;
                root = end;
                index = 0;
            }
            head = head.next;
        }
        // 在第一次旋转时，会绑定dummy
        // 因为此题最少旋转一次，下面写法包含不旋转的情况
        return dummy.next == null ? head : dummy.next;
    }

    /**
     * 递归 更好理解
     */
    public static ListNode reverseKGroupRec(ListNode head, int k) {
        // 找新链尾部
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                // 不够k个 返回原链
                return head;
            }
            tail = tail.next;
        }
        // 旋转单链表，返回新链头节点
        ListNode newHead = reverse(head, tail);
        // 旋转后续链表，并返回旋转后的链头
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    /**
     * 旋转单链表，返回新链头节点
     */
    private static ListNode reverse(ListNode head, ListNode pre) {
        // end记录新链尾部
        ListNode end = pre;
        // 最后一个不旋转
        while (head != end) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseKGroupRec(listNode, 2);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, ans = nums[0];
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            int count = map.get(num) + 1;
            map.put(num, count);
            if (count > max) {
                max = count;
                ans = num;
            }
        }
        return ans;
    }
}
