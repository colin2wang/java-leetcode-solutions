package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class S0208_Implement_Trie_Prefix_Tree {

    class Trie {
        private String word;
        private Map<Character, Trie> children;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.word = "";
            children = new HashMap<>();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie current = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new Trie());
                }
                current = current.children.get(c);
            }
            current.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie current = this;
            for (Character ch : word.toCharArray()) {
                current = current.children.get(ch);
                if (current == null) {
                    return false;
                }
            }

            return word.equals(current.word);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie current = this;
            for (Character ch : prefix.toCharArray()) {
                current = current.children.get(ch);
                if (current == null) {
                    return false;
                }
            }

            return !current.children.isEmpty() || prefix.equals(current.word);
        }
    }

    @Test
    public void test() {

        {
            /**
             * ["Trie","insert","search","startsWith"]
             * [[],["a"],["a"],["a"]]
             */
            Trie trie = new Trie();
            trie.insert("a");
            Assertions.assertTrue(trie.search("a"));
            Assertions.assertTrue(trie.startsWith("a"));
        }

        {
            Trie trie = new Trie();
            trie.insert("apple");
            Assertions.assertTrue(trie.search("apple"));
            Assertions.assertFalse(trie.search("app"));
            Assertions.assertTrue(trie.startsWith("app"));
            trie.insert("app");
            Assertions.assertTrue(trie.search("app"));
        }

        {
            Trie trie = new Trie();
            Assertions.assertFalse(trie.startsWith("app"));
        }

        {
            /**
             * ["Trie","insert","search","search","search","startsWith","startsWith","startsWith"]
             * [[],["hello"],["hell"],["helloa"],["hello"],["hell"],["helloa"],["hello"]]
             */
            Trie trie = new Trie();
            trie.insert("hello");
            Assertions.assertFalse(trie.search("hell"));
            Assertions.assertFalse(trie.search("helloa"));
            Assertions.assertTrue(trie.search("hello"));
            Assertions.assertTrue(trie.startsWith("hell"));
            Assertions.assertFalse(trie.startsWith("helloa"));
            Assertions.assertTrue(trie.startsWith("hello"));
        }
    }
}
