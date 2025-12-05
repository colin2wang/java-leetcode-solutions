package com.colin.leetcode;

import org.junit.jupiter.api.Test;

public class S0002_Add_Two_Numbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static ListNode build(int value) {
        ListNode node = new ListNode(value % 10);
        value /= 10;
        ListNode p = node;
        while (value != 0) {
            p.next = new ListNode(value % 10);
            value /= 10;
            p = p.next;
        }
        return node;
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            ListNode p1 = l1;
            ListNode p2 = l2;

            ListNode newListNode = new ListNode((p1.val + p2.val) % 10);
            newListNode.next = new ListNode((p1.val + p2.val) / 10);
            ListNode pNew = newListNode;
            p1 = p1.next;
            p2 = p2.next;

            while (p1 != null || p2 != null) {
                int pValue = pNew.next.val + (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0);
                pNew.next.val = pValue % 10;
                pNew.next.next = new ListNode(pValue / 10);

                pNew = pNew.next;
                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }
            }

            if (pNew.next.val == 0) {
                pNew.next = null;
            }
            return newListNode;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
//        Assertions.assertArrayEquals(expecteds, solution.twoSum(nums, 9));
        ListNode lRet = solution.addTwoNumbers(build(1000), build(20));
        System.out.println(lRet);
    }
}
