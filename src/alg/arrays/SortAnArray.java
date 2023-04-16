package alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-an-array/
 *
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest
 * space complexity possible.
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3),
 * while the positions of other numbers are changed (for example, 1 and 5).
 *
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 5 * 10^4
 *     -5 * 10^4 <= nums[i] <= 5 * 10^4
 */
public class SortAnArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5,2,3,1}))); //[1,2,3,5]
        System.out.println(Arrays.toString(sortArray(new int[]{5,1,1,2,0,0}))); // [0,0,1,1,2,5]
    }

    private static int[] sortArray(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return nums;
        }

        int mid = length / 2;
        int[] first = new int[mid];
        System.arraycopy(nums, 0, first, 0, mid);

        int[] second = new int[length - mid];
        System.arraycopy(nums, mid, second, 0, length - mid);

        int[] sortedFirstAr = sortArray(first);
        int[] sortedSecondAr = sortArray(second);

        return mergeStep(sortedFirstAr, sortedSecondAr);
    }

    private static int[] mergeStep(int[] firstArr, int[] secondArr) {
        int firstLength = firstArr.length;
        int secondLength = secondArr.length;

        int[] res = new int[firstLength + secondLength];
        int i = 0;
        int firstIdx = 0;
        int secondIdx = 0;
        while (firstIdx < firstLength && secondIdx < secondLength) {
            if (firstArr[firstIdx] < secondArr[secondIdx]) {
                res[i++] = firstArr[firstIdx++];
            } else {
                res[i++] = secondArr[secondIdx++];
            }
        }

        while (firstIdx < firstLength) {
            res[i++] = firstArr[firstIdx++];
        }
        while (secondIdx < secondLength) {
            res[i++] = secondArr[secondIdx++];
        }

        return res;
    }
}
