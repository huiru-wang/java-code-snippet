package com.snippet.algo.lcci;

/**
 * 使用快慢指针，如果是环，一定会有一刻，停在相同的节点，假设是D点
 * <p>
 * A - B(C) - - -<Br/>
 * &ensp;&ensp;&ensp;&ensp;&ensp;|&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;|<Br/>
 * &ensp;&ensp;&ensp;&ensp;&ensp;----D--<Br/>
 * 就有：慢指针走了: AB + BD, 快指针走了：AB + BC + BD<Br/>
 * 且快指针走的是慢指针的两倍距离：2(AB+BD) = AB + BC + DB  <Br/>
 * =>  AB + BD = BC  <Br/>
 * =>  AB = BC - BD<Br/>
 * 即：AB = DC<Br/>
 * 即：相遇后，慢指针到B点的距离 == A到B的距离，再使用两个指针，同步走，直到相遇即可；
 * <p>
 * create by whr on 2023-04-09
 */
public class Q2_8_LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        if (fast == null || fast.next == null) {
            return null;
        }
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != null && fast.next != null && fast != slow);
        if (fast == null || fast.next == null) {
            return null;
        }
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return slow;
    }
}
