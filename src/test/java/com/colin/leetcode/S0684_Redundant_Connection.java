package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class S0684_Redundant_Connection {

    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int length = edges.length;
            int[] parents = new int[length + 1];

            for (int[] edge : edges) {
                int node1Root = findRoot(parents, edge[0]);
                int node2Root = findRoot(parents, edge[1]);

                if (node1Root == node2Root) {
                    return edge;
                }

                parents[node2Root] = node1Root;
            }
            return null;
        }


        private int findRoot(int[] parents, int node) {
            int idx = node;
            int parent = parents[idx];
            if (parent > 0) {
                return findRoot(parents, parent);
            } else {
                return idx;
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{2, 3}, solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        Assertions.assertArrayEquals(new int[]{1, 4}, solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
        Assertions.assertArrayEquals(new int[]{2, 5}, solution.findRedundantConnection(new int[][]{{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}}));
    }
}
