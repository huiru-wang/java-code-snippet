package com.snippet.algo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * create by whr on 2023-07-07
 */
public class LC103_zigzagLevelOrder {

    // BFS每次交替队列出队的方向
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean direction = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] array = new Integer[size];
            int index = direction ? 0 : size - 1;
            int step = direction ? 1 : -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                array[index] = node.val;
                index = index + step;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            direction = !direction;
            ans.add(List.of(array));
        }
        return ans;
    }
}
