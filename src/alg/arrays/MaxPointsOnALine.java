package alg.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number
 * of points that lie on the same straight line.
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 *
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *Math
 *
 * Constraints:
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * All the points are unique.
 */
public class MaxPointsOnALine {

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}})); // 3
        System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}})); // 4
    }

    private static int maxPoints(int[][] points) {
        int length = points.length;
        if (length == 1) {
            return 1;
        }
        int res = 2; // min value for any 2 points
        Map<Double, Integer> counter = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            counter.clear();
            for (int j = 0; j < length; ++ j) {
                if (i == j) {
                    continue;
                }
                counter.merge(Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]), 1, Integer::sum);
            }
            res = Math.max(res, Collections.max(counter.values()) + 1); // + 1 because we need to include base point with index = i
        }
        return res;
    }
}
