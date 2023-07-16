package com.snippet.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最小深度
 * <p>
 * create by whr on 2023-07-06
 */
public class LC111_minDeep {

    // 最优解是BFS，可以提前终止
    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return min;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            min++;
        }
        return min;
    }

    // 与求最大深度类似
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
