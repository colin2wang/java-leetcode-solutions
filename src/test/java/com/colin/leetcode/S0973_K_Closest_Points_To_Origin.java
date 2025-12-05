package com.colin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class S0973_K_Closest_Points_To_Origin {

//    class Solution {
//        public int[][] kClosest(int[][] points, int K) {
//            java.util.SortedMap<Double, List<int[]>> distanceMap = new TreeMap<>();
//
//            for (int[] point : points) {
//                double distance = Math.sqrt(Math.pow(point[0], 2)+ Math.pow(point[1], 2));
//                List<int[]> distanceList = distanceMap.get(distance);
//                if (distanceList == null) {
//                    distanceList = new ArrayList<>();
//                    distanceMap.put(distance, distanceList);
//                }
//                distanceList.add(point);
//            }
//
//            List<int[]> lRet = new ArrayList<>();
//
//            for (Map.Entry<Double, List<int[]>> entry : distanceMap.entrySet()) {
//                if (K <= 0) {
//                    break;
//                }
//                List<int[]> value = entry.getValue();
//                K -= value.size();
//                lRet.addAll(value);
//            }
//
//            return lRet.toArray(new int[0][0]);
//        }
//    }

    class Solution {
        /**
         * Sort use Java Stream
         *
         * @param points
         * @param K
         * @return
         */
        public int[][] kClosest(int[][] points, int K) {
            return Arrays.stream(points).sorted(new Comparator<int[]>() {
                @Override
                public int compare(int[] point1, int[] point2) {
                    Double distance1 = Math.pow(point1[0], 2)+ Math.pow(point1[1], 2);
                    Double distance2 = Math.pow(point2[0], 2)+ Math.pow(point2[1], 2);

                    return distance1.compareTo(distance2);
                }
            }).limit(K).collect(Collectors.toList()).toArray(new int[0][0]);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Object result = null;

//        result = solution.kClosest(new int[][] {{1,3}, {-2,2}}, 1);
//        System.out.println(result);

        result = solution.kClosest(new int[][] {{-2,2},{2,-2},{1,3}}, 2);
        System.out.println(result);
    }
}
