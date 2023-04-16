package alg.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 *     i + 1 where: i + 1 < arr.length.
 *     i - 1 where: i - 1 >= 0.
 *     j where: arr[i] == arr[j] and i != j.
 *
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 *
 * Example 2:
 *
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You do not need to jump.
 *
 * Example 3:
 *
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 5 * 10^4
 *     -10^8 <= arr[i] <= 10^8
 */
public class JumpGameIV {

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404})); // 3
        System.out.println(minJumps(new int[]{7})); // 0
        System.out.println(minJumps(new int[]{7,6,9,6,9,6,9,7})); // 1
    }

    private static int minJumps(int[] arr) {
        int length = arr.length;
        // neighbour's indexes with the same value
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            indices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited = new boolean[length];
        visited[0] = true;

        int stepsNumber = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int checkedIdx = queue.poll();
                if (checkedIdx == length - 1) {
                    return stepsNumber;
                }

                if (checkedIdx - 1 >= 0 && !visited[checkedIdx - 1]) {
                    queue.offer(checkedIdx - 1);
                }
                if (checkedIdx + 1 < length && !visited[checkedIdx + 1]) {
                    queue.offer(checkedIdx + 1);
                }

                List<Integer> additionalIdxs = indices.get(arr[checkedIdx]);
                if (additionalIdxs != null){
                    for (int idx : additionalIdxs) {
                        if (idx >= 0 && idx < length && !visited[idx]) {
                            queue.offer(idx);
                        }
                    }
                }
                visited[checkedIdx] = true;
                indices.remove(arr[checkedIdx]);
            }
            ++stepsNumber;
        }

        return -1;
    }
}
