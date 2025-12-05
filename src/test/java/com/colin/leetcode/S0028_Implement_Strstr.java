package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
//        Assertions.assertEquals(2, solution.strStr("hello", "ll"));
//        Assertions.assertEquals(-1, solution.strStr("aaaaa", "bba"));
//        Assertions.assertEquals(1, solution.strStr("baa", "a"));
//        Assertions.assertEquals(0, solution.strStr("aaa", "a"));
//        Assertions.assertEquals(0, solution.strStr("", ""));
//        Assertions.assertEquals(3, solution.strStr("aabaaa", "aaa"));
        Assertions.assertEquals(4, solution.strStr("mississippi", "issip"));
    }
}
