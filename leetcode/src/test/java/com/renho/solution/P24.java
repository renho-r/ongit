package com.renho.solution;

import com.renho.model.ListNode;
import org.junit.Test;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P24 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = swapPairs(head);
        System.out.println(result.val);
    }

    /**
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode nextNode = head.next, nextHead = nextNode.next;
        nextNode.next = head;
        head.next = swapPairs(nextHead);
        return nextNode;
    }

}
