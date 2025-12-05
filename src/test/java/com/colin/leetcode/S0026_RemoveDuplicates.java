package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class S0026_RemoveDuplicates {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int cur = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[cur] != nums[i]) {
                    nums[++cur] = nums[i];
                }
            }
            return cur + 1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expecteds[] = {0, 1, 2, 3, 4};
        Assertions.assertEquals(5, solution.removeDuplicates(nums));
        Assertions.assertArrayEquals(expecteds, Arrays.copyOf(nums, 5));
    }
}
