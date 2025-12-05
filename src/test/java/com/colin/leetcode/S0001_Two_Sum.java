package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class S0001_Two_Sum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i ++) {
                int remainder = target - nums[i];
                if(map.containsKey(nums[i]))
                    return new int[]{map.get(nums[i]), i};
                map.put(remainder, i);
            }
            throw new IllegalArgumentException("no solution.");
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int nums[] = {2,7,11,15};
        int expecteds[] = {0,1};
        Assertions.assertArrayEquals(expecteds, solution.twoSum(nums, 9));
    }
}
