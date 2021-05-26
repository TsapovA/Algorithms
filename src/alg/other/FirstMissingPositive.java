package alg.other;

/**
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2, 1}));
        System.out.println(firstMissingPositive(new int[]{1, 1}));
        System.out.println(firstMissingPositive(new int[]{0}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    private static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0] == 1 ? 2 : 1;
        }

        for (int i = 0; i < length; ++i) {
            if (nums[i] > 0 && nums[i] < length && nums[i] != i) {
                // avoid cycling dependency
                if (nums[i] != nums[nums[i]]) {
                    swap(nums, nums[i], i);
                    --i;
                }
            }
        }
        for (int i = 1; i < length; ++i) {
            if (nums[i] != i) return i;
        }

        if (nums[length - 1] == length - 1) {
            // check case when nums[0] has length value
            if (nums[0] == length) return length + 1;
            return length;
        }
        return length;
    }

    private static void swap(int[] nums, int idxTo, int idxFrom) {
        int temp = nums[idxTo];
        nums[idxTo] = nums[idxFrom];
        nums[idxFrom] = temp;
    }
}
