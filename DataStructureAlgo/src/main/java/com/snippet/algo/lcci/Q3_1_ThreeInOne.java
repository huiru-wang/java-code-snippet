package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-09
 */
public class Q3_1_ThreeInOne {
    static class TripleInOne {

        int[] array;

        int[] stackCapacity;

        int capacity;

        public TripleInOne(int stackSize) {
            this.capacity = stackSize;
            this.array = new int[3 * this.capacity];
            this.stackCapacity = new int[3];
        }

        public void push(int stackNum, int value) {
            if (stackCapacity[stackNum] > this.capacity - 1) {
                return;
            }
            int curIndex = stackCapacity[stackNum];
            array[stackNum * this.capacity + curIndex] = value;
            stackCapacity[stackNum]++;
        }

        public int pop(int stackNum) {
            if (stackCapacity[stackNum] == 0) {
                return -1;
            }
            int curIndex = stackCapacity[stackNum];
            stackCapacity[stackNum]--;
            return array[stackNum * this.capacity + curIndex - 1];
        }

        public int peek(int stackNum) {
            if (stackCapacity[stackNum] == 0) {
                return -1;
            }
            return array[stackNum * this.capacity + stackCapacity[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return stackCapacity[stackNum] <= 0;
        }
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        boolean empty = tripleInOne.isEmpty(0);
        System.out.println(empty);
    }
}
