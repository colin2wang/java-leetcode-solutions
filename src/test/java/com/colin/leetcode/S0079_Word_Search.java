package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode Problem 79: Word Search
 * <p>
 * This class contains a solution to the problem of finding if a word exists in a 2D board.
 * The solution uses a backtracking algorithm to explore all possible paths in the grid.
 */
public class S0079_Word_Search {

    /**
     * Solution class for the Word Search problem
     */
    class Solution {
        /**
         * Determines if a given word exists in the 2D board.
         * 
         * @param board 2D character grid representing the board
         * @param word string to search for in the board
         * @return true if the word exists, false otherwise
         */
        public boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            // Visited matrix to keep track of visited cells
            boolean[][] visited = new boolean[h][w];
            
            // Iterate through each cell in the board
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // Check if the word starts at current cell
                    boolean flag = check(board, visited, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Recursive backtracking function to check if the word can be found starting from (i,j) at position k.
         * 
         * @param board 2D character grid
         * @param visited matrix to track visited cells
         * @param i current row index
         * @param j current column index
         * @param s the word to search for
         * @param k current position in the word
         * @return true if the word can be found from this position, false otherwise
         */
        public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
            // Check if current cell matches the current character in the word
            if (board[i][j] != s.charAt(k)) {
                return false;
            } 
            // If we've reached the end of the word, return true
            else if (k == s.length() - 1) {
                return true;
            }
            
            // Mark current cell as visited
            visited[i][j] = true;
            
            // Directions: right, left, down, up
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            
            // Explore all four directions
            for (int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                // Check if new position is within bounds and not visited
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!visited[newi][newj]) {
                        // Recursively check next character in the word
                        boolean flag = check(board, visited, newi, newj, s, k + 1);
                        if (flag) {
                            result = true;
                            break; // No need to check other directions
                        }
                    }
                }
            }
            
            // Backtrack: unmark current cell as visited
            visited[i][j] = false;
            return result;
        }
    }

    /**
     * Test cases for the word search solution
     */
    @Test
    public void test() {
        Solution solution = new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        
        // Test case 1: Word "ABCCED" should exist
        Assertions.assertTrue(solution.exist(board, "ABCCED"));
        
        // Test case 2: Word "SEE" should exist
        Assertions.assertTrue(solution.exist(board, "SEE"));
        
        // Test case 3: Word "ABCB" should not exist
        Assertions.assertFalse(solution.exist(board, "ABCB"));
    }
}