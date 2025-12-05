package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S1342_Number_Of_Steps_To_Reduce_A_Number_To_Zero {

    class Solution {
        public int numberOfSteps (int num) {
            int count = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    num -= 1;
                } else {
                    num /= 2;
                }
                count++;
            }
            return count;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.numberOfSteps(0));
        Assertions.assertEquals(1, solution.numberOfSteps(1));
        Assertions.assertEquals(6, solution.numberOfSteps(14));
        Assertions.assertEquals(4, solution.numberOfSteps(8));
        Assertions.assertEquals(12, solution.numberOfSteps(123));
    }
}
