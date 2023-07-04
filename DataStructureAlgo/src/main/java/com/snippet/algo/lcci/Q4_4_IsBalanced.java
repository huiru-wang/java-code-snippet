package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-23
 */
public class Q4_4_IsBalanced {

    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
