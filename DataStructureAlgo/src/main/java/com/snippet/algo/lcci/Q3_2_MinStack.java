package com.snippet.algo.lcci;

/**
 * 1. use Java PriorityQueue
 * 2. use ListNode, every node save the current min value;
 * create by whr on 2023-04-15
 */
public class Q3_2_MinStack {
    class MinStack {

        Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x, null);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    private static class Node {
        public int val;
        public int min;
        public Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
