package com.snippet.algo.tree;

/**
 * create by whr on 2023-07-03
 */
public class TreeOrder {

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.val);
        inOrder(treeNode.right);
    }

    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("=========== pre Order ===========");
        preOrder(treeNode);

        System.out.println("=========== in Order ===========");
        inOrder(treeNode);

        System.out.println("=========== post Order ===========");
        postOrder(treeNode);
    }
}
