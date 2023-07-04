package com.snippet.algo.tree;

/**
 * create by whr on 2023-07-03
 */
public class LC543_diameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return max;
    }

    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        int diameter = Math.max(left, 0) + Math.max(right, 0);
        max = Math.max(diameter, max);
        return Math.max(left, right) + 1;
    }
}
