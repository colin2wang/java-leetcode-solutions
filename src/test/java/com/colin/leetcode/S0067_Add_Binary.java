package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode Problem 67: Add Binary
 * <p>
 * This class contains a solution to the problem of adding two binary strings
 * and returning their sum as a binary string.
 */
public class S0067_Add_Binary {

    /**
     * Solution class for adding binary strings
     */
    class Solution {
        /**
         * Adds two binary strings and returns their sum as a binary string.
         * 
         * @param a first binary string
         * @param b second binary string
         * @return sum of a and b as a binary string
         */
        public String addBinary(String a, String b) {
            // Pointers for the end of both strings
            int i = a.length() - 1;
            int j = b.length() - 1;
            
            // Carry to store the overflow from each addition
            int carry = 0;
            
            // StringBuilder to build the result
            StringBuilder builder = new StringBuilder();
            
            // Loop until both pointers are exhausted and no carry remains
            while (i >= 0 || j >= 0 || carry > 0) {
                // Start with the carry from previous iteration
                int sum = carry;
                
                // Add the current bit from string a if available
                if (i >= 0) {
                    sum += a.charAt(i--) - '0';
                }
                
                // Add the current bit from string b if available
                if (j >= 0) {
                    sum += b.charAt(j--) - '0';
                }
                
                // Append the least significant bit of the sum to the result
                builder.append(sum % 2);
                
                // Update carry for next iteration
                carry = sum / 2;
            }
            
            // Reverse the builder to get the correct order
            return builder.reverse().toString();
        }
    }

    /**
     * Test cases for the addBinary method
     */
    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals("100", solution.addBinary("11", "1"));
        Assertions.assertEquals("11", solution.addBinary("10", "1"));
        Assertions.assertEquals("101", solution.addBinary("11", "10"));
    }
}