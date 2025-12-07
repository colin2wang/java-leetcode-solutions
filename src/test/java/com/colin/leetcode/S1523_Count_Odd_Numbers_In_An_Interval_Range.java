package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S1523_Count_Odd_Numbers_In_An_Interval_Range {

    class Solution {
        public int countOdds(int low, int high) {
            int dist = high - low;
            int count = dist / 2;

            if (high % 2 == 1 || low % 2 == 1) {
                count++;
            }

            return count;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.countOdds(3, 7));
        Assertions.assertEquals(1, solution.countOdds(8, 10));
        Assertions.assertEquals(1, solution.countOdds(2, 4));
        Assertions.assertEquals(2, solution.countOdds(2, 5));
        Assertions.assertEquals(3, solution.countOdds(1, 5));
        Assertions.assertEquals(0, solution.countOdds(2, 2));
        Assertions.assertEquals(1, solution.countOdds(1, 1));
    }
}