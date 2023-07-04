package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-09
 */
public class Q2_3_DeleteMiddleNode {
    public void deleteNode(ListNode head) {
        head.val = head.next.val;
        head.next = head.next.next;
    }
}
