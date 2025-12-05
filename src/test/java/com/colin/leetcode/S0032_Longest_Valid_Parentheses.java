package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;


// TODO
public class S0032_Longest_Valid_Parentheses {

    // Wrong
    /*
    class Solution {
        public int longestValidParentheses(String s) {
            int iRet = 0;

            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                switch (ch) {
                    case '(':
                        if (stack.isEmpty() || stack.peek() == ')') {
                            stack.push(ch);
                        } else {
                            iRet = Math.max(iRet, stack.size());
                            stack.clear();
                            stack.push(ch);
                        }
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.push(ch);
                        } else {
                            iRet = Math.max(iRet, stack.size());
                            stack.clear();
                        }
                        break;
                    default:
                        break;
                }
            }

            return Math.max(iRet, stack.size() % 2 == 1 ? stack.size() - 1 : stack.size());
        }
    }
    */

    class Solution {
        public int longestValidParentheses(String s) {
            int left = 0;
            int right = 0;
            int max = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                switch (ch) {
                    case '(':
                        left++;
                        break;
                    case ')':
                        right++;
                        break;
                    default:
                        break;
                }

                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }


            left = 0;
            right = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(s.length() - 1 - i);
                switch (ch) {
                    case ')':
                        left++;
                        break;
                    case '(':
                        right++;
                        break;
                    default:
                        break;
                }

                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }

            return max;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.longestValidParentheses("())"));
        Assertions.assertEquals(4, solution.longestValidParentheses("()()"));
        Assertions.assertEquals(2, solution.longestValidParentheses("()(()"));
        Assertions.assertEquals(2, solution.longestValidParentheses("(()"));
        Assertions.assertEquals(4, solution.longestValidParentheses("))()()"));
        Assertions.assertEquals(2, solution.longestValidParentheses("()("));
        Assertions.assertEquals(0, solution.longestValidParentheses(")))))))"));
        Assertions.assertEquals(0, solution.longestValidParentheses("((((((("));
        Assertions.assertEquals(0, solution.longestValidParentheses("("));
        Assertions.assertEquals(0, solution.longestValidParentheses("))))"));
        Assertions.assertEquals(6, solution.longestValidParentheses("()()()"));
        Assertions.assertEquals(6, solution.longestValidParentheses("(()())"));
        Assertions.assertEquals(14, solution.longestValidParentheses("(()())()()()()"));
        Assertions.assertEquals(14, solution.longestValidParentheses("(()())()()()()))()()"));
    }
}

