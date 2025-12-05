package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S0039_Combination_Sum {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> llRet = new ArrayList<>();

            collectAll(candidates, target, llRet);

            return llRet;
        }

        private void collectAll(int[] candidates, int target, List<List<Integer>> llRet) {
            for (int candidate : candidates) {
                List<Integer> lRet = new ArrayList<>();
                int remain = target - candidate;
                if (remain > 0) {
                    lRet.add(candidate);
                    collect(candidates, remain, lRet, llRet);
                } else if (target == candidate) {
                    llRet.add(Arrays.asList(candidate));
                }
            }
        }

        private void collect(int[] candidates, int target, List<Integer> lRet, List<List<Integer>> llRet) {
            for (int candidate : candidates) {
                List<Integer> part = new ArrayList<>(lRet);
                int remain = target - candidate;
                if (remain > 0) {
                    part.add(candidate);
                    collect(candidates, remain, part, llRet);
                } else if (remain == 0) {
                    part.add(candidate);
                    Collections.sort(part);
                    if (!llRet.contains(part)) {
                        llRet.add(part);
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(solution.combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9));
    }
}
