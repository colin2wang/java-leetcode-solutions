package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0066_Plus_One {

    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            digits[len-1]++;

            for (int i = len - 1; i >= 1; i--) {
                if (digits[i] == 10) {
                    digits[i] = 0;
                    digits[i - 1]++;
                }
            }

            if  (digits[0] == 10) {
                digits[0] = 0;
                int[] ret = new int[len + 1];
                ret[0] = 1;
                System.arraycopy(digits, 0, ret, 1, len);
                return ret;
            }

            return digits;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assertions.assertArrayEquals(new int[]{1, 2, 4}, solution.plusOne(new int[]{1, 2, 3}));
        Assertions.assertArrayEquals(new int[]{1, 0}, solution.plusOne(new int[]{9}));
        Assertions.assertArrayEquals(new int[]{1, 0, 0}, solution.plusOne(new int[]{9, 9}));
    }
}