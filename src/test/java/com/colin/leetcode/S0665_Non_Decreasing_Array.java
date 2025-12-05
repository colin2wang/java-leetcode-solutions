package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0665_Non_Decreasing_Array {
    // TODO: ?
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int hit = 0;
            for (int idx = 0; idx < nums.length - 1; idx++) {
                if (nums[idx] > nums[idx + 1]) {
                    int swap = nums[idx];
                    if (idx < 1) {
                        nums[idx] = nums[idx + 1];
                    } else {
                        nums[idx] = nums[idx - 1];
                    }
                    if (nums[idx] > nums[idx + 1]) {
                        nums[idx] = swap;
                        nums[idx + 1] = nums[idx];
                    }
                    hit++;
                    if (hit >= 2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(true, solution.checkPossibility(new int[]{2, 3, 3, 2, 4}));
        Assertions.assertEquals(false, solution.checkPossibility(new int[]{3, 4, 2, 3}));
        Assertions.assertEquals(false, solution.checkPossibility(new int[]{4, 2, 1}));
        Assertions.assertEquals(true, solution.checkPossibility(new int[]{4, 2, 3}));
        Assertions.assertEquals(true, solution.checkPossibility(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(false, solution.checkPossibility(new int[]{4, 3, 2, 1}));
    }
}
