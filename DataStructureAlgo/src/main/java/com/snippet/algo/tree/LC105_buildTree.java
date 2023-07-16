package com.snippet.algo.tree;

import java.util.Arrays;

/**
 * create by whr on 2023-07-04
 */
public class LC105_buildTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        while (index < inorder.length) {
            if (inorder[index] == preorder[0]) {
                break;
            }
            index++;
        }
        // 3 | 9 8 1 | 20 15 7
        // 8 9 1 | 3 | 15 20 7
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + index, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preOrder, inOrder);
    }
}
