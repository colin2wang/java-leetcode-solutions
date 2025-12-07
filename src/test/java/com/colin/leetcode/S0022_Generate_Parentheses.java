package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 22: Generate Parentheses
 * <p>
 * This class contains a solution to generate all combinations of well-formed parentheses
 * for a given number of pairs using a backtracking algorithm.
 */
public class S0022_Generate_Parentheses {

    /**
     * Solution class for the Generate Parentheses problem
     */
    class Solution {
        /**
         * Generates all combinations of well-formed parentheses for n pairs.
         * 
         * @param n the number of pairs of parentheses
         * @return list of all valid parentheses combinations
         */
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<String>();
            // Start backtracking with empty string and 0 open/close parentheses
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        /**
         * Backtracking helper method to generate valid parentheses combinations.
         * 
         * @param ans list to store valid combinations
         * @param cur current combination being built
         * @param open number of open parentheses used so far
         * @param close number of close parentheses used so far
         * @param max maximum number of pairs allowed
         */
        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            // Base case: if current string has all parentheses pairs, add to result
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            
            // If we can add more open parentheses, do so
            if (open < max) {
                cur.append('(');  // Add open parenthesis
                backtrack(ans, cur, open + 1, close, max);  // Recurse with incremented open count
                cur.deleteCharAt(cur.length() - 1);  // Backtrack: remove last character
            }
            
            // If we can add more close parentheses (only if we have more open than close), do so
            if (close < open) {
                cur.append(')');  // Add close parenthesis
                backtrack(ans, cur, open, close + 1, max);  // Recurse with incremented close count
                cur.deleteCharAt(cur.length() - 1);  // Backtrack: remove last character
            }
        }
    }

    /**
     * Test cases for the Generate Parentheses solution
     */
    @Test
    public void test() {
        Solution solution = new Solution();
        
        // Test case 1: Single pair of parentheses
        Assertions.assertEquals(List.of("()"), solution.generateParenthesis(1));
        
        // Test case 2: Three pairs of parentheses (all possible valid combinations)
        Assertions.assertEquals(List.of("((()))","(()())","(())()","()(())","()()()"), solution.generateParenthesis(3));
    }
}