package alg.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/
 *
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The test cases are generated so that the answer fits in 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [2,4,6,8,10]
 * Output: 7
 * Explanation: All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * Example 2:
 *
 * Input: nums = [7,7,7,7,7]
 * Output: 16
 * Explanation: Any subsequence of this array is arithmetic.
 *
 *
 * Constraints:
 *
 * 1  <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class ArithmeticSlices2Subsequence {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10})); // 7
        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7})); // 16
    }

    private static int numberOfArithmeticSlices(int[] A) {
        int length = A.length;
        Map<Integer, Integer>[] cnt = new Map[length];
        int ans = 0;
        for (int i = 0; i < length; ++i) {
            cnt[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                long delta = (long) A[i] - (long) A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int dif = (int) delta;
                int sum = cnt[j].getOrDefault(dif, 0);
                int origin = cnt[i].getOrDefault(dif, 0);
                cnt[i].put(dif, origin + sum + 1);
                ans += sum;
            }
        }
        return ans;
    }
}
