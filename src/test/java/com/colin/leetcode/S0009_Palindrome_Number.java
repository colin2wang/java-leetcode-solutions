package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0009_Palindrome_Number {

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int value = x;
            long res = 0;
            while (value != 0) {
                res = res * 10 + value % 10;
                value /= 10;
            }
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return false;
            return x ==res;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(true, solution.isPalindrome(121));
        Assertions.assertEquals(true, solution.isPalindrome(123321));
        Assertions.assertEquals(true, solution.isPalindrome(11111));
        Assertions.assertEquals(false, solution.isPalindrome(12345));
        Assertions.assertEquals(false, solution.isPalindrome(-12321));
    }
}
