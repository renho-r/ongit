package com.renho.solution;

import com.renho.model.ListNode;
import org.junit.Test;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P141 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        boolean flag = hasCycle(head);
        System.out.println(flag);
    }

    public boolean hasCycle(ListNode head) {
        if(null==head || null==head.next) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while(slow != fast) {
            if(null==fast || null==fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
