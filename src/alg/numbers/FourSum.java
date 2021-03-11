package alg.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Notice that the solution set must not contain duplicate quadruplets.
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [], target = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 200
 * -10^(9) <= nums[i] <= 10^9
 * -10^(9) <= target <= 10^9
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{}, 0));
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    /**
     * Check if the sum of k smallest values is greater than target, or the sum of k largest values is smaller than target.
     * Since the array is sorted, the smallest value is nums[start], and largest - the last element in nums.
     * If so, no need to continue - there are no k elements that sum to target.
     *
     * If k equals 2, call twoSum and return the result.
     *
     * Iterate i through the array from start:
     * If the current value is the same as the one before, skip it.
     * Recursively call kSum with start = i + 1, k = k - 1, and target - nums[i].
     * For each returned set of values:
     * Include the current value nums[i] into set.
     * Add set to the result res.
     * Return the result res.
     */
    private static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> set: kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(set));
                    res.get(res.size() - 1).add(nums[i]);
                }
            }
        }
        return res;
    }

    /**
     * Set the low pointer lo to start, and high pointer hi to the last index.
     * While low pointer is smaller than high:
     * If the sum of nums[lo] and nums[hi] is less than target, increment lo.
     * Also increment lo if the value is the same as for lo - 1.
     * If the sum is greater than target, decrement hi.
     * Also decrement hi if the value is the same as for hi + 1.
     * Otherwise, we found a pair:
     * Add it to the result res.
     * Decrement hi and increment lo.
     * Return the result res.
     */
    private static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                res.add(Arrays.asList(nums[lo], nums[hi]));
                while (lo < hi && nums[lo] == nums[lo + 1]) ++lo;
                while (lo < hi && nums[hi] == nums[hi - 1]) --hi;
                ++lo;
                --hi;
            } else if (sum < target) {
                while (lo < hi && nums[lo] == nums[lo + 1]) ++lo;
                ++lo;
            } else {
                while (lo < hi && nums[hi] == nums[hi - 1]) --hi;
                --hi;
            }
        }
        return res;
    }
}
