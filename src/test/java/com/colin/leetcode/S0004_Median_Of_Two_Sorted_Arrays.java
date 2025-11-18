package com.colin.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S0004_Median_Of_Two_Sorted_Arrays {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            List<Integer> allNums = new ArrayList<>();

            for (int num : nums1) {
                allNums.add(num);
            }

            for (int num : nums2) {
                allNums.add(num);
            }

            Collections.sort(allNums);

            int length = allNums.size();

            double dRet;
            if (length % 2 == 1) {
                dRet = allNums.get(length / 2);
            } else {
                dRet = (allNums.get(length / 2 - 1) + allNums.get(length / 2)) / 2.0;
            }

            return dRet;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    }
}