package com.snippet.algo.tree;

/**
 * create by whr on 2023-07-03
 */
public class LC104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
