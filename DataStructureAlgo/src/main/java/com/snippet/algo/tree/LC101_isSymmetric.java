package com.snippet.algo.tree;


/**
 * create by whr on 2023-07-03
 */
public class LC101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return match(root, root);
    }

    private boolean match(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return match(root1.left, root2.right) && match(root1.right, root2.left);
    }
}
