package com.xiaohan.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class no_199_binary_tree_right_side_view {

    /**
     * BFS
     */
    public List<Integer> rightSideView_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            result.add(queue.peek().val);
            Deque<TreeNode> temp = new ArrayDeque<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                if (null != node.right) {
                    temp.addLast(node.right);
                }
                if (null != node.left) {
                    temp.addLast(node.left);
                }
            }
            queue = temp;
        }
        return result;
    }
}
