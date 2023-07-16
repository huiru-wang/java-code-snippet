package com.snippet.algo.tree;

/**
 * create by whr on 2023-07-10
 */
public class LC572_isSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean flag = dfs(root, subRoot);
        return flag || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        int len = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            String substring = strs[0].substring(0, i + 1);
            for (int j = 0; j < len; j++) {
                String cur = strs[j];
                if (cur.length() <= i || !substring.equals(strs[j].substring(0, i + 1))) {
                    return ans;
                }
                if (j == len - 1) {
                    ans = substring;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }
}
