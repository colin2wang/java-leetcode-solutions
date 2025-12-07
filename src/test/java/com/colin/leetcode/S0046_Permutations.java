package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode Problem 46: Permutations
 * <p>
 * This class contains a solution to generate all possible permutations of an array of distinct integers
 * using a backtracking algorithm with swap operations.
 */
public class S0046_Permutations {

    /**
     * Solution class for the Permutations problem
     */
    class Solution {
        /**
         * Generates all possible permutations of the given array of integers.
         * 
         * @param nums the array of distinct integers to permute
         * @return list of all possible permutations
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            // Convert array to List for easier manipulation
            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            // Start backtracking from the first position
            backtrack(n, output, res, 0);
            return res;
        }

        /**
         * Backtracking helper method to generate permutations.
         * 
         * @param n total number of elements
         * @param output current permutation being built
         * @param res list to store all permutations
         * @param first index of the first element to consider for permutation
         */
        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // Base case: all elements have been fixed
            if (first == n) {
                // Add a copy of the current permutation to results
                res.add(new ArrayList<Integer>(output));
            }
            
            // Iterate through elements from 'first' to end of list
            for (int i = first; i < n; i++) {
                // Swap current element with element at 'first' position
                Collections.swap(output, first, i);
                // Recurse to fix the next element
                backtrack(n, output, res, first + 1);
                // Backtrack: swap elements back to original positions
                Collections.swap(output, first, i);
            }
        }
    }

    /**
     * Test cases for the Permutations solution
     */
    @Test
    public void test() {
        Solution solution = new Solution();

        // Test case 1: 3 elements (6 permutations)
        List<List<Integer>> res = solution.permute(new int[] {1, 2, 3});
        Assertions.assertEquals(6, res.size());  // 3! = 6
        Assertions.assertTrue(res.contains(List.of(1, 2, 3)));
        Assertions.assertTrue(res.contains(List.of(1, 3, 2)));
        Assertions.assertTrue(res.contains(List.of(2, 1, 3)));
        Assertions.assertTrue(res.contains(List.of(2, 3, 1)));
        Assertions.assertTrue(res.contains(List.of(3, 1, 2)));
        Assertions.assertTrue(res.contains(List.of(3, 2, 1)));

        // Test case 2: 4 elements (24 permutations)
        List<List<Integer>> res2 = solution.permute(new int[] {1, 2, 3, 4});
        Assertions.assertEquals(24, res2.size());  // 4! = 24

        // Test case 3: 5 elements (120 permutations)
        List<List<Integer>> res3 = solution.permute(new int[] {1, 2, 3, 4, 5});
        Assertions.assertEquals(120, res3.size());  // 5! = 120
    }
}