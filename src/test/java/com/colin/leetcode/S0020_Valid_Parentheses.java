package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class S0020_Valid_Parentheses {
    class Solution {
        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

            if (!s.matches("[\\[\\]\\(\\){}]*")) {
                return false;
            }

            for (char ch : s.toCharArray()) {
                switch (ch) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(ch);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') {
                            return false;
                        }
                        stack.pop();
                        break;
                    default:
                        break;
                }
            }

            return stack.isEmpty();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(true, solution.isValid("[][]"));
        Assertions.assertEquals(true, solution.isValid("({[]})"));
        Assertions.assertEquals(true, solution.isValid("()[]{}"));
        Assertions.assertEquals(false, solution.isValid("[]]]"));
        Assertions.assertEquals(false, solution.isValid("[(])"));
        Assertions.assertEquals(false, solution.isValid("sdf"));
    }
}

