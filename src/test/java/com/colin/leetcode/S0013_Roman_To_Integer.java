package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class S0013_Roman_To_Integer {

    class Solution {
        Map<Character, Integer> map = new HashMap<>();

        public Solution() {
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }

        public int romanToInt(String s) {
            int sum = 0;
            char[] chs = s.toCharArray();
            for (int idx = 0; idx<chs.length; idx++) {
                char ch = chs[idx];
                sum = add(sum, chs, idx);
                sum = fix(sum, chs, idx);
            }
            return sum;
        }

        private int add(int sum, char[] chs, int idx) {
            sum += map.get(chs[idx]);
            return sum;
        }

        private int fix(int sum, char[] chs, int idx) {
            if (idx > 0) {
                char ch1 = chs[idx - 1];
                char ch2 = chs[idx];

                if (map.get(ch1) < map.get(ch2)) {
                    sum -= map.get(ch1) * 2;
                }
            }
            return sum;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.romanToInt("I"));
        Assertions.assertEquals(4, solution.romanToInt("IV"));
        Assertions.assertEquals(11, solution.romanToInt("XI"));
        Assertions.assertEquals(58, solution.romanToInt("LVIII"));
        Assertions.assertEquals(1994, solution.romanToInt("MCMXCIV"));

    }
}
