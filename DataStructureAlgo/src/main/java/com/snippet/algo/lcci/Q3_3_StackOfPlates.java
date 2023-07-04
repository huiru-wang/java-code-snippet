package com.snippet.algo.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * create by whr on 2023-04-15
 */
public class Q3_3_StackOfPlates {
    class StackOfPlates {

        List<List<Integer>> stack;

        int capacity;

        public StackOfPlates(int cap) {
            this.capacity = cap;
            stack = new ArrayList<>();
        }

        public void push(int val) {
            if (this.capacity <= 0) {
                return;
            }
            if (stack.isEmpty() || stack.get(stack.size() - 1).size() >= capacity) {
                List<Integer> plates = new ArrayList<>();
                plates.add(val);
                stack.add(plates);
            } else {
                List<Integer> peek = stack.get(stack.size() - 1);
                peek.add(val);
            }
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int lastIndex = stack.size() - 1;
            List<Integer> list = stack.get(lastIndex);
            Integer remove = list.remove(list.size() - 1);
            if (list.isEmpty()) {
                stack.remove(lastIndex);
            }
            return remove;
        }

        public int popAt(int index) {
            int stackSize = stack.size();
            if (index >= stackSize) {
                return -1;
            }
            List<Integer> list = stack.get(index);
            Integer remove = list.remove(list.size() - 1);
            if (list.isEmpty()) {
                stack.remove(index);
            }
            return remove;
        }
    }

}
