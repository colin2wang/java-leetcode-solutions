package com.colin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class S0047_Permutations_Ii {
    class Solution {
        protected void append(List<List<Integer>> lRet, List<Integer> root, List<Integer> rest) {
            if (rest.size() == 1) {
                List<Integer> copy = new ArrayList<>(root);
                copy.add(rest.get(0));
                lRet.add(copy);
            } else {
                Set<Integer> all = new HashSet<>();
                all.addAll(rest);

                for (Integer elem : all) {
                    int idx = rest.indexOf(elem);
                    List<Integer> copy = new ArrayList<>(root);
                    copy.add(rest.get(idx));
                    append(lRet, copy, subList(rest, idx));
                }

//                for (int idx = 0; idx < rest.size(); idx++) {
//                    List<Integer> copy = new ArrayList<>(root);
//                    copy.add(rest.get(idx));
//                    append(lRet, copy, subList(rest, idx));
//                }
            }
        }

        protected List<Integer> subList(List<Integer> oList, int skipIdx) {
            List<Integer> nList = new ArrayList<>();

            for (int idx = 0; idx < oList.size(); idx++) {
                if (skipIdx == idx) {
                    // Skip
                } else {
                    nList.add(oList.get(idx));
                }
            }

            return nList;
        }

        public List<List<Integer>> permuteUnique(int[] nums) {

            if (nums.length == 1) {
                return Arrays.asList(Arrays.asList(nums[0]));
            }

            List<Integer> numList = new ArrayList<>();
            for (int idx = 0; idx < nums.length; idx++) {
                numList.add(nums[idx]);
            }

            List<List<Integer>> sRet = new ArrayList<>();
            List<Integer> root = new ArrayList<>();
            append(sRet, root, numList);

            return new ArrayList<>(sRet);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.subArray(new int[] {1, 2, 3, 4})));
        System.out.println(solution.permuteUnique(new int[] {}));
        System.out.println(solution.permuteUnique(new int[] {1}));
        System.out.println(solution.permuteUnique(new int[] {1, 2, 1}));
        System.out.println(solution.permuteUnique(new int[] {1, 2, 3}));
    }
}

