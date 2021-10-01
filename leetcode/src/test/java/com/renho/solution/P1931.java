package com.renho.solution;

import org.junit.Test;

import java.util.*;

/**
 * @author renho
 * @date 2021/6/10
 */
public class P1931 {

    @Test
    public void test() {
        ListNode ln = new ListNode(1);
        ListNode head = ln;
        ln.next = new ListNode(3);
        ln = ln.next;
        ln.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
//        if (null==head || 0==head.) {
//
//        }
        return printListNode(head, 0);
    }

    private int[] printListNode(ListNode head, int size) {
        if (null != head.next) {
            int[] result = printListNode(head.next, size + 1);
            result[result.length - size - 1] = head.val;
            return result;
        } else {
            int[] result = new int[size + 1];
            result[0] = head.val;
            return result;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
