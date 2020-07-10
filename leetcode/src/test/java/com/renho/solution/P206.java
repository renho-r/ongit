package com.renho.solution;

import com.renho.model.ListNode;
import org.junit.Test;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P206 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseList(head);
        System.out.println(result.val);
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head, nextNode = head.next, tmp = null;
        head.next = null;
        while(null != nextNode) {
            tmp = nextNode.next;
            nextNode.next = cur;
            cur = nextNode;
            nextNode = tmp;
        }
        return cur;
    }

}
