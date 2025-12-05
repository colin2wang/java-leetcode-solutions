package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0044_Wildcard_Matching {

    class Solution {
        public boolean isMatch(String s, String p) {
            if (p.length() == 0)
                return s.length() == 0;
            StringBuilder builder = new StringBuilder();
            builder.append(p.charAt(0));
            for (int i = 1; i < p.length(); i++) {
                if (p.charAt(i) == '*' && p.charAt(i - 1) == '*')
                    continue;
                builder.append(p.charAt(i));
            }
            p = builder.toString();
            boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i <= p.length(); i++) {
                char c1 = p.charAt(i - 1);
                if (c1 == '*') {
                    int j = 0;
                    while (j <= s.length() && !dp[i - 1][j])
                        j++;
                    while (j <= s.length())
                        dp[i][j++] = true;
                } else {
                    for (int j = 1; j <= s.length(); j++) {
                        char c2 = s.charAt(j - 1);
                        if (c1 == c2 || c1 == '?')
                            dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[p.length()][s.length()];
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isMatch("abcbcdc", "a*cdc"));
        Assertions.assertTrue(solution.isMatch("abc", "a?c"));
    }
}
