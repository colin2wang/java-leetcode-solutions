package com.colin.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class S0014_Longest_Common_Prefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {

            StringBuffer max = new StringBuffer();

            int point = 0;

            while (true) {
                for (int idx = 0; idx < strs.length; idx++) {
                    String str = strs[idx];
                    if (point >= str.length()) {
                        return max.substring(0, point);
                    }

                    if (idx == 0) {
                        max.append(str.charAt(point));
                    } else {
                        if (str.charAt(point) != max.charAt(point)) {
                            return max.substring(0, point);
                        }
                    }

                }
                point++;
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assert.assertEquals("a", solution.longestCommonPrefix(new String[] {"ab", "a"}));
        Assert.assertEquals("abc", solution.longestCommonPrefix(new String[] {"abc", "abc", "abcabc"}));
        Assert.assertEquals("", solution.longestCommonPrefix(new String[] {"abc", "def", "ghi"}));
        Assert.assertEquals("a", solution.longestCommonPrefix(new String[] {"abc", "aaa", "asdf"}));
    }
}