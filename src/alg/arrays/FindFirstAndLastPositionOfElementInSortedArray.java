package alg.arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{0, 0, 0, 1, 2, 3}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 4}, 4)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                int left = findLeftIdx(nums, mid, low);
                int right = findRightIdx(nums, mid, high);
                return new int[]{left, right};
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    private static int findLeftIdx(int[] nums, int rightBorder, int lowIdxToStart) {
        int target = nums[rightBorder];
        int low = lowIdxToStart;
        int high = rightBorder;
        int mid = 0;
        while (low <= high) {
            if (low == high) return low;

            mid = (low + high) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }

    private static int findRightIdx(int[] nums, int leftBorder, int highIdxToStart) {
        int target = nums[leftBorder];
        int low = leftBorder;
        int high = highIdxToStart;
        int mid = 0;
        while (low <= high) {
            if (low == high) return low;

            mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid == high - 1) {
                    return nums[high] == target ? high : mid;
                }
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return mid;
    }
}
