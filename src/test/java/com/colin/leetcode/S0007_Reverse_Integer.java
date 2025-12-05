package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0007_Reverse_Integer {

    class Solution {
        public int reverse(int x) {
            long res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            return (int)res;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(321, solution.reverse(123));
        Assertions.assertEquals(981, solution.reverse(1890));
        Assertions.assertEquals(-321, solution.reverse(-123));
        Assertions.assertEquals(0, solution.reverse(1534236469));
    }
}
