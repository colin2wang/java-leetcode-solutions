package com.colin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class S0025_Reverse_Nodes_In_K_Group {

    /**
     * 示例
     *
     * 给你这个链表 ->2->3->4->5
     *
     * 当k= 2 时，应当返回: 2->1->4->3->5
     *
     * 当k= 3 时，应当返回: 3->2->1->4->5
     */
    public static ListNode buildListNodes(int... values) {
        ListNode root = null;
        ListNode cur = null;

        for (int value : values) {
            if (root == null) {
                root = new ListNode(value);
                cur = root;
            } else {
                ListNode next = new ListNode(value);
                cur.next = next;
                cur = cur.next;
            }
        }

        return root;
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k <= 1) {
                return head;
            }

            ListNode newHead = visit(head, k);

            ListNode cur = head;
            ListNode newCur = null;

            while (cur != null && ensure(cur, k)) {
                Stack<ListNode> stack = new Stack<>();
                ListNode rest = visit(cur, k + 1);
                for (int i = 0; i < k; i++) {
                    stack.push(cur);
                    cur = cur.next;
                }

                newCur = stack.pop();
                while (!stack.isEmpty()) {
                    newCur.next = stack.pop();
                    newCur = newCur.next;
                }
                ListNode next = visit(cur, k);
                newCur.next = next != null ? next : cur;
                cur = rest;
            }

            return newHead;
        }

        protected boolean ensure(ListNode head, int num) {
            ListNode cur = head;
            for (int i = 1; i < num; i++) {
                if (cur == null) {
                    return false;
                }
                cur = cur.next;
            }

            return cur != null;
        }

        protected ListNode visit(ListNode head, int num) {
            ListNode cur = head;
            for (int i = 1; i < num; i++) {
                if (cur == null) {
                    return head;
                }
                cur = cur.next;
            }

            return cur;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode listNode = buildListNodes(1, 2, 3, 4, 5);
        ListNode resolvedNode = solution.reverseKGroup(listNode, 3);
//        ListNode listNode = buildListNodes(1, 2);
//        ListNode resolvedNode = solution.reverseKGroup(listNode, 2);
        System.out.println(resolvedNode);
    }
}
