package com.snippet.algo.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * create by whr on 2023-07-01
 */
public class LC143_reorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            if (i < size / 2) {
                nodes.get(i).next = nodes.get(size - i - 1);
            } else {
                nodes.get(i).next = nodes.get(size - i);
            }
        }
        nodes.get(size / 2).next = null;
    }
}
