package alg.other;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 *     0 <= j <= nums[i] and
 *     i + j < n
 *
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 10^4
 *     0 <= nums[i] <= 1000
 *     It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4})); // 2
        System.out.println(jump(new int[]{2,3,0,1,4})); // 2
        System.out.println(jump(new int[]{0})); // 0
        System.out.println(jump(new int[]{3,1,1,1,1})); // 2
        System.out.println(jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3})); // 2
    }

    private static int jump(int[] nums) {
        int length = nums.length;
        int curLast = 0;
        int last = 0;
        int res = 0;
        for (int i = 0; i < length - 1; ++i) {
            if (last < i + nums[i]) {
                last = Math.min(i + nums[i], length - 1);
                if (last >= length - 1) {
                    ++res;
                    break;
                }
            }
            if (i >= curLast) {
                ++res;
                curLast = last;
            }
        }
        return res;
    }
}
