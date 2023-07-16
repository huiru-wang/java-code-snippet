package com.snippet.algo.tree;

/**
 * create by whr on 2023-07-08
 */
public class LC337_robIII {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = root.val;
        return Math.max(ans, rob(root.left) + rob(root.right));
    }
}
