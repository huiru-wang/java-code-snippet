package com.snippet.algo.lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * &ensp;&ensp;&ensp;&ensp;4-3-| <br/>
 * &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;8-4-5<br/>
 * 1-2-3-7-|<br/>
 * set不停查询，增大了时间复杂度<br/>
 * 应该将两个链表截取成相同长度，一起next，找到相同节点，即可<br/>
 * <p>
 * create by whr on 2023-04-09
 */
public class Q2_7_IntersectionOfTwoLinkedList {

    // set不停查询，增大了时间复杂度
    // 应该将两个链表截取成相同长度，一起next，找到相同节点，即可
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (set.contains(headA)) {
                    return headA;
                } else {
                    set.add(headA);
                }
                headA = headA.next;
            }
            if (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                } else {
                    set.add(headB);
                }
                headB = headB.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        if (len1 >= len2) {
            return getNode(len1, len2, headA, headB);
        } else {
            return getNode(len2, len1, headB, headA);
        }
    }

    private ListNode getNode(int longer, int shorter, ListNode longerListNode, ListNode shorterListNode) {
        int diff = longer - shorter;
        while (diff != 0) {
            longerListNode = longerListNode.next;
            diff--;
        }
        while (shorterListNode != longerListNode) {
            shorterListNode = shorterListNode.next;
            longerListNode = longerListNode.next;
        }
        return shorterListNode;
    }
}
