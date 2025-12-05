package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S0040_Combination_Sum_Ii {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            int sum = Arrays.stream(candidates).sum();
            if (sum < target) {
                return Arrays.asList();
            }

            List<List<Integer>> llRet = new ArrayList<>();
            List<Integer> candidateList = new ArrayList<>();
            Arrays.stream(candidates).forEach(value -> candidateList.add(value));

            collectAll(candidateList, target, llRet);

            return llRet;
        }

        private void collectAll(List<Integer> candidateList, int target, List<List<Integer>> llRet) {
            for (int candidate : candidateList) {
                List<Integer> lRet = new ArrayList<>();
                int remain = target - candidate;
                if (remain > 0) {
                    lRet.add(candidate);
                    collect(cut(candidateList, candidate), remain, lRet, llRet);
                } else if (target == candidate) {
                    List<Integer> part = Arrays.asList(candidate);
                    if (!llRet.contains(part)) {
                        llRet.add(part);
                    }
                }
            }
        }

        private void collect(List<Integer> candidateList, int target, List<Integer> lRet, List<List<Integer>> llRet) {
            for (int candidate : candidateList) {
                List<Integer> part = new ArrayList<>(lRet);
                int remain = target - candidate;
                if (remain > 0) {
                    part.add(candidate);
                    collect(cut(candidateList, candidate), remain, part, llRet);
                } else if (remain == 0) {
                    part.add(candidate);
                    Collections.sort(part);
                    if (!llRet.contains(part)) {
                        llRet.add(part);
                    }
                }
            }
        }

        private List<Integer> cut(List<Integer> candidateList, int candidate) {
            List<Integer> restList = new ArrayList<>(candidateList);
            restList.remove(new Integer(candidate));
            return restList;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combinationSum2(new int[]{1, 1}, 1));
        System.out.println(solution.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 27));
    }
}
