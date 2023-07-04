package com.snippet.algo.lcci;

/**
 * 1. 双栈：比较复杂
 * 2. 链表
 * 3. 最小堆
 * create by whr on 2023-04-18
 */
public class Q3_5_SortStack {
    class SortedStack {
        Node head;

        public SortedStack() {
        }

        public void push(int val) {
            if (head == null) {
                head = new Node(val, null);
                return;
            }
            if (head.val >= val) {
                head = new Node(val, head);
            } else {
                Node cur = head;
                while (cur.next != null && cur.next.val < val) {
                    cur = cur.next;
                }
                cur.next = new Node(val, cur.next);
            }
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }
        }

        public int peek() {
            return head == null ? -1 : head.val;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    private static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
