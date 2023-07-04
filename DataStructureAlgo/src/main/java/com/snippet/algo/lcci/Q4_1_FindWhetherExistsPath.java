package com.snippet.algo.lcci;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * create by whr on 2023-04-22
 */
public class Q4_1_FindWhetherExistsPath {
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] node = new boolean[n];
        node[start] = true;
        for (int[] edge : graph) {
            if (node[edge[0]]) {
                node[edge[1]] = true;
            }
        }
        // graph不一定是排序的，需要标记两次
        for (int[] edge : graph) {
            if (node[edge[0]]) {
                if (edge[1] == target) {
                    return true;
                }
                node[edge[1]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        //System.out.println(queue.remove());

    }
}
