package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode Problem 31: Next Permutation
 * <p>
 * This class contains a solution to the problem of finding the next lexicographically greater permutation
 * of a sequence of numbers. If such permutation does not exist, it rearranges the numbers into the lowest
 * possible order (ascending order).
 */
public class S0031_Next_Permutation {

    /**
     * Solution class for the Next Permutation problem
     */
    class Solution {
        /**
         * Rearranges numbers into the lexicographically next greater permutation of numbers.
         * If such an arrangement is not possible, it rearranges it as the lowest possible order.
         * 
         * @param nums the array of integers to permute
         */
        public void nextPermutation(int[] nums) {
            // Step 1: Find the first decreasing element from the end
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            
            // Step 2: If found, find the element just larger than nums[i] from the end
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                // Step 3: Swap these two elements
                swap(nums, i, j);
            }
            
            // Step 4: Reverse the elements after i to get the next permutation
            reverse(nums, i + 1);
        }

        /**
         * Helper method to swap two elements in an array
         * 
         * @param nums the array containing elements to swap
         * @param i index of first element
         * @param j index of second element
         */
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /**
         * Helper method to reverse elements in an array from a given start index to the end
         * 
         * @param nums the array to reverse
         * @param start the starting index for reversal
         */
        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }

    /**
     * Test cases for the next permutation solution
     */
    @Test
    public void test() {
        Solution solution = new Solution();

        // Test case 1: Regular case - next permutation of [1, 2, 3] is [1, 3, 2]
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        Assertions.assertArrayEquals(new int[]{1, 3, 2}, nums);

        // Test case 2: Descending order - next permutation of [3, 2, 1] is [1, 2, 3]
        nums = new int[]{3, 2, 1};
        solution.nextPermutation(nums);
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, nums);

        // Test case 3: With duplicates - next permutation of [1, 1, 5] is [1, 5, 1]
        nums = new int[]{1, 1, 5};
        solution.nextPermutation(nums);
        Assertions.assertArrayEquals(new int[]{1, 5, 1}, nums);

        // Test case 4: Complex case - next permutation of [1, 2, 1, 3] is [1, 2, 3, 1]
        nums = new int[]{1, 2, 1, 3};
        solution.nextPermutation(nums);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 1}, nums);
    }
}