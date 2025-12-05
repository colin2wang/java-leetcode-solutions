package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S0017_Letter_Combinations_Of_A_Phone_Number {

    class Solution {
        Map<String, String> map = new HashMap<>();

        public Solution() {
            map.put("2", "abc");
            map.put("3", "def");
            map.put("4", "ghi");
            map.put("5", "jkl");
            map.put("6", "mno");
            map.put("7", "pqrs");
            map.put("8", "tuv");
            map.put("9", "wxyz");
        }

        public List<String> letterCombinations(String digits) {
            List<String> collection = new ArrayList<>();
            for (char ch : digits.toCharArray()) {

                recall(collection, ch);
            }

            return collection;
        }

        protected void recall(List<String> collection, char digit) {
            if (collection.isEmpty()) {
                for (char ch : map.get(String.valueOf(digit)).toCharArray()) {
                    collection.add(String.valueOf(ch));
                }
            } else {
                List<String> newCollection = new ArrayList<>();
                for (String elem : collection) {
                    for (char ch : map.get(String.valueOf(digit)).toCharArray()) {
                        newCollection.add(elem + String.valueOf(ch));
                    }
                }
                collection.clear();
                collection.addAll(newCollection);
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
    }
}
