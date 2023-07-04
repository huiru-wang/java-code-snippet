package com.snippet.algo.lcci;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * create by whr on 2023-04-23
 */
public class Q4_3_ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode node = new ListNode(-1);
            ListNode cur = node;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                cur.next = new ListNode(poll.val);
                cur = cur.next;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(node.next);
        }
        return res.toArray(new ListNode[]{});
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
