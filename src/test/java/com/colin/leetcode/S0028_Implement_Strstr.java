package com.colin.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class S0028_Implement_Strstr {

    class Solution {
        public int strStr(String haystack, String needle) {
            int hIdx = 0;
            int nIdx = 0;
            int hLen = haystack.length();
            int nLen = needle.length();
            if (nLen == 0) {
                return 0;
            }
            while (hIdx < hLen) {
                char hChar = haystack.charAt(hIdx);
                char nChar = needle.charAt(nIdx);
                if (hChar != nChar) {
                    nIdx = 0;
                } else {
                    nIdx++;
                }

                if (nIdx >= nLen) {
                    return hIdx - nLen + 1;
                }
                hIdx++;
            }
            return -1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
//        Assert.assertEquals(2, solution.strStr("hello", "ll"));
//        Assert.assertEquals(-1, solution.strStr("aaaaa", "bba"));
//        Assert.assertEquals(1, solution.strStr("baa", "a"));
//        Assert.assertEquals(0, solution.strStr("aaa", "a"));
//        Assert.assertEquals(0, solution.strStr("", ""));
//        Assert.assertEquals(3, solution.strStr("aabaaa", "aaa"));
        Assert.assertEquals(4, solution.strStr("mississippi", "issip"));
    }
}