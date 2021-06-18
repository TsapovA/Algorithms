package alg.numbers;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
 * same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Example 3:
 * Input: nums = [0]
 * Output: [0]
 *
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        // two markers for both sides of the array. Position for the white color is determined in the middle of the markers.
        final int red = 0;
        final int blue = 2;

        int redIdxToInsert = 0;
        int blueIdxToInsert = nums.length - 1;

        for (int idx = 0; idx <= blueIdxToInsert;) {
            if (nums[idx] == red) {
                if (idx != redIdxToInsert) {
                    swap(nums, idx, redIdxToInsert);
                }
                ++idx;
                ++redIdxToInsert;
            } else if (nums[idx] == blue) {
                swap(nums, idx, blueIdxToInsert--);
            } else {
                ++idx;
            }
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = temp;
    }
}
