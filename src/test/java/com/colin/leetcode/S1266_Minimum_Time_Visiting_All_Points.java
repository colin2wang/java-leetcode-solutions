package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S1266_Minimum_Time_Visiting_All_Points {

    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int iRet = 0;

            int[] pPoint = points[0];
            for (int idx = 1; idx < points.length; idx++) {
                int[] cPoint = points[idx];
                iRet += Math.max(Math.abs(cPoint[0] - pPoint[0]), Math.abs(cPoint[1] - pPoint[1]));
                pPoint = cPoint;
            }
            return iRet;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(7, solution.minTimeToVisitAllPoints(new int[][] {{1,1},{3,4},{-1,0}}));
        Assertions.assertEquals(5, solution.minTimeToVisitAllPoints(new int[][]  {{3,2},{-2,2}}));
        Assertions.assertEquals(0, solution.minTimeToVisitAllPoints(new int[][]  {{3,2}}));
    }
}
