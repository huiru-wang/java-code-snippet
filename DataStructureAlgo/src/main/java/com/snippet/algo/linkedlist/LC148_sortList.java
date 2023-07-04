package com.snippet.algo.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * create by whr on 2023-07-02
 */
public class LC148_sortList {
    public ListNode sortList(ListNode head) {
        List<ListNode> sortedList = new ArrayList<>();
        while (head != null) {
            sortedList.add(head);
            head = head.next;
        }
        sortedList.sort(Comparator.comparing(item -> item.val));
        for (int i = 0; i < sortedList.size(); i++) {
            if (i == sortedList.size() - 1) {
                sortedList.get(i).next = null;
                break;
            }
            sortedList.get(i).next = sortedList.get(i + 1);
        }
        return sortedList.isEmpty() ? null : sortedList.get(0);
    }
}
