package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0008_String_To_Integer_Atoi {

    class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            long lRet = 0l;
            try {
                lRet = Long.valueOf(str);
            } catch (Exception e) {
                // Cannot parse by Long
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("^ *[+-]?[0-9]+").matcher(str);
                if (matcher.find()) {
                    String value = matcher.group(0);
                    try {
                        lRet = Long.valueOf(value);
                    } catch (Exception ex) {
                        if (value.startsWith("-")) {
                            return Integer.MIN_VALUE;
                        } else {
                            return Integer.MAX_VALUE;
                        }
                    }
                }
            }

            lRet = lRet <= Integer.MAX_VALUE ? lRet : Integer.MAX_VALUE;
            lRet = lRet >= Integer.MIN_VALUE ? lRet : Integer.MIN_VALUE;

            return (int) lRet;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(11, solution.myAtoi("+11e530408314"));
        Assertions.assertEquals(2147483647, solution.myAtoi("20000000000000000000"));
        Assertions.assertEquals(-12, solution.myAtoi("  -0012a42"));
        Assertions.assertEquals(0, solution.myAtoi("ww-4193 with words"));
        Assertions.assertEquals(4193, solution.myAtoi("4193 with words"));
        Assertions.assertEquals(-4193, solution.myAtoi("-4193 with words"));
        Assertions.assertEquals(-42, solution.myAtoi("   -42"));
        Assertions.assertEquals(-2147483648, solution.myAtoi("-91283472332"));

    }
}
