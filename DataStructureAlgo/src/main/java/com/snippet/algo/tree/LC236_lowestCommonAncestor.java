package com.snippet.algo.tree;


/**
 * 公共祖先
 * 深搜：当前树找到target，返回target，没找到返回null
 * 只有公共父节点，才会收到两个target
 * <p>
 * create by whr on 2023-07-09
 */
public class LC236_lowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
