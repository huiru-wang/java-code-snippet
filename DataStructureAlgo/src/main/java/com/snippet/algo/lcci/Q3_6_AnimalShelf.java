package com.snippet.algo.lcci;

import java.util.LinkedList;

/**
 * create by whr on 2023-04-18
 */
public class Q3_6_AnimalShelf {
    static class AnimalShelf {

        LinkedList<int[]> linkedList;

        int catSize;

        int dogSize;

        public AnimalShelf() {
            catSize = 0;
            dogSize = 0;
            linkedList = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            linkedList.add(animal);
            if (animal[1] == 0) {
                catSize++;
            } else {
                dogSize++;
            }
        }

        public int[] dequeueAny() {
            if (linkedList.isEmpty()) {
                return new int[]{-1, -1};
            }
            int[] last = linkedList.removeFirst();
            if (last[1] == 0) {
                catSize--;
            } else {
                dogSize--;
            }
            return last;
        }

        public int[] dequeueDog() {
            if (dogSize == 0) {
                return new int[]{-1, -1};
            }
            dogSize--;
            return pop(1);
        }

        public int[] dequeueCat() {
            if (catSize == 0) {
                return new int[]{-1, -1};
            }
            catSize--;
            return pop(0);
        }

        private int[] pop(int type) {
            int size = linkedList.size();
            int[] target = new int[0];
            for (int i = 0; i < size; i++) {
                if (linkedList.get(i)[1] == type) {
                    target = linkedList.remove(i);
                    break;
                }
            }
            return target;
        }
    }

    public static void main(String[] args) {
        AnimalShelf animalShelf = new AnimalShelf();
        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});
        animalShelf.dequeueCat();
        animalShelf.dequeueDog();
        animalShelf.dequeueAny();
    }
}
