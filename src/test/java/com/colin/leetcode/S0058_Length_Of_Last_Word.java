package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0058_Length_Of_Last_Word {

    class Solution {
        public int lengthOfLastWord(String s) {
            String words[] = s.trim().split(" ");
            return words[words.length - 1].length();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assertions.assertEquals(5, solution.lengthOfLastWord("Hello World"));
        Assertions.assertEquals(4, solution.lengthOfLastWord("   fly me   to   the moon  "));
        Assertions.assertEquals(6, solution.lengthOfLastWord("luffy is still joyboy"));
    }
}
