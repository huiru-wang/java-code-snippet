package com.snippet.algo.tree;

/**
 * create by whr on 2023-07-07
 */
public class LC101_isBalanced {
    private boolean done;

    // 求左右树的深度，并提前退出
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return done;
    }

    private int depth(TreeNode root) {
        if (done && root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) {
            done = true;
        }
        return Math.max(left, right) + 1;
    }
}
