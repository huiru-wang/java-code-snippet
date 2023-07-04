package com.snippet.algo.lcci;

/**
 * create by whr on 2023-04-22
 */
public class Q4_2_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(nums, 0, nums.length - 1);
    }

    private TreeNode generate(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start], null, null);
        }
        int mid = (end - start) / 2 + start;
        return new TreeNode(nums[mid], generate(nums, start, mid - 1), generate(nums, mid + 1, end));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Q4_2_SortedArrayToBST test = new Q4_2_SortedArrayToBST();
        TreeNode treeNode = test.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
