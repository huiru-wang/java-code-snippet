package com.snippet.algo.tree;

/**
 * create by whr on 2023-07-07
 */
public class JZ36_treeToDoublyList {

    TreeNode pre;
    TreeNode head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        toList(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void toList(TreeNode root) {
        if (root == null) {
            return;
        }
        toList(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        toList(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        TreeNode res = new JZ36_treeToDoublyList().treeToDoublyList(treeNode);
        System.out.println(res.val);
    }
}