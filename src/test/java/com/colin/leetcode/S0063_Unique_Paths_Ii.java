package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0063_Unique_Paths_Ii {

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[][] dp = new int[m + 1][n + 1];
            dp[1][0] = 1;
            for (int x = 1; x <= m; x++) {
                for (int y = 1; y <= n; y++) {
                    if (obstacleGrid[x - 1][y - 1] == 1) {
                        continue;
                    } else {
                        dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
    }
}
