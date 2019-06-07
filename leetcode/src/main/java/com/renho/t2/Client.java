package com.renho.t2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

public class Client {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> liQ = new ArrayDeque<>();
        return null;
    }
}
