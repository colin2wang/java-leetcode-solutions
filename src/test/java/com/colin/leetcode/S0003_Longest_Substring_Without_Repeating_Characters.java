package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0003_Longest_Substring_Without_Repeating_Characters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            char chars[] = s.toCharArray();

            switch (chars.length) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                default:
                    return forward(chars);
            }
        }

        protected int forward(char[] chars) {
            int count = 0;
            int max = 0;

            for (int start = 0; start < chars.length; start++) {
                int[] charArray = new int[128];
                for (int idx = start; idx < chars.length; idx++) {
                    char ch = chars[idx];
                    if (charArray[ch] == 1) {
                        if (count > max) {
                            max = count;
                        }
                        count = 1;
                    } else {
                        charArray[ch] = 1;
                        count++;
                    }
                }
                max = Math.max(count, max);
                count = 0;
            }

            return max;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assertions.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(1, solution.lengthOfLongestSubstring(" "));
        Assertions.assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
        Assertions.assertEquals(6, solution.lengthOfLongestSubstring("asjrgapa"));
    }
}
