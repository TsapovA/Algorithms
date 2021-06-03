package alg.arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1})); // -1
        System.out.println(maxSubArray(new int[]{-2, 1})); // 1
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{1})); // 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
    }

    private static int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];

        for (int num : nums) {
            sum += num;
            res = Math.max(res, sum);
            if (sum < 0) sum = 0;
        }
        return res;
    }
}
