package alg.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{0, 1}));
        System.out.println(permute(new int[]{1}));
    }

    // recursive

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(calculateFactorial(nums.length));
        for (int i = 0; i < nums.length; ++i) {
            performPermute(result, nums, 1);
            moveArrayOneStepLeft(nums, 0);
        }
        return result;
    }

    private static void performPermute(List<List<Integer>> result, int[] nums, int idx) {
        if (idx >= nums.length - 1) {
            result.add(createListFromArray(nums));
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            performPermute(result, nums, idx + 1);
            moveArrayOneStepLeft(nums, idx);
        }
    }

    private static void moveArrayOneStepLeft(int[] nums, int idx) {
        int temp = nums[idx];
        for (int i = idx; i < nums.length - 1; ++i) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = temp;
    }

    private static List<Integer> createListFromArray(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num: nums) {
            list.add(num);
        }
        return list;
    }

    private static int calculateFactorial(int num) {
        int res = 1;
        for (int i = 2; i <= num; ++i) {
            res *= num;
        }
        return res;
    }
}
