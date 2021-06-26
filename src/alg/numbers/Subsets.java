package alg.numbers;

import java.util.*;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *  Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *  Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 *  Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsetsCascading(new int[]{1, 2, 3}));
        System.out.println(subsetsCascading(new int[]{0}));

        System.out.println(subsetsLexicographic(new int[]{1, 2, 3}));
        System.out.println(subsetsLexicographic(new int[]{0}));

        System.out.println(subsetsBacktracking(new int[]{1, 2, 3}));
        System.out.println(subsetsBacktracking(new int[]{0}));
    }

    // Cascading time: O(N * 2^N), space: O(N * 2^N)
    private static List<List<Integer>> subsetsCascading(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());

        for (int idx = 0; idx < nums.length; ++idx) {
            performPermutationCascading(nums, idx, res);
        }
        return res;
    }

    private static void performPermutationCascading(int[] nums, int idx, List<List<Integer>> res) {
        List<List<Integer>> currentList = new ArrayList<>(res);
        for (List<Integer> val: currentList) {
            List<Integer> newMember = new ArrayList<>(val);
            newMember.add(nums[idx]);
            res.add(newMember);
        }
    }

    // Lexicographic time: O(N * 2^N), space: O(N * 2^N)
    private static List<List<Integer>> subsetsLexicographic(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int length = nums.length;
        int n = 1 << length;

        for (int i = 0; i < n; ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i | n).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < length; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }

    // Backtracking (most efficient in terms of the used space) time: O(N * 2^N), space: O(N)
    private static List<List<Integer>> subsetsBacktracking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // i - final list size to add to result
        for (int i = 0; i <= nums.length; ++i) {
            backtrack(nums, new ArrayList<>(i), result, i, 0);
        }
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> currentList, List<List<Integer>> result, int listSize, int currentIdx) {
        if (currentList.size() == listSize) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = currentIdx; i < nums.length; ++i) {
            currentList.add(nums[i]);
            backtrack(nums, currentList, result, listSize, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
