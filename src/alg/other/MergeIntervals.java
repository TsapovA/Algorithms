package alg.other;

import java.util.*;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= start[i] <= end[i] <= 10^4
 */
public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {1, 4}})));
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new LinkedList<>();
        int[] tempArr = intervals[0];

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= tempArr[1]) {
                tempArr[1] = Math.max(tempArr[1], intervals[i][1]);
            } else {
                result.add(tempArr);
                tempArr = intervals[i];
            }
        }
        if (result.isEmpty() || result.get(result.size() - 1)[1] < tempArr[1]) {
            result.add(tempArr);
        }
        return result.toArray(new int[result.size()][]);
    }
}
