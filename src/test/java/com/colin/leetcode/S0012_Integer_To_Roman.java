package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0012_Integer_To_Roman {

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    class Solution {
        public String intToRoman(int num) {
            int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String chars[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            int idx = 0;
            StringBuilder output = new StringBuilder();

            while (num > 0) {
                if (num >= values[idx]) {
                    num -= values[idx];
                    output.append(chars[idx]);
                } else {
                    idx++;
                }
            }

            return output.toString();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assertions.assertEquals("I", solution.intToRoman(1));
        Assertions.assertEquals("IV", solution.intToRoman(4));
        Assertions.assertEquals("MCMXCIV", solution.intToRoman(1994));

    }
}
