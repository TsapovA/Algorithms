package alg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
 *
 * You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 *
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
 * Output: 4
 * Explanation: To complete all the tasks, a possible plan is:
 * - In the first round, you complete 3 tasks of difficulty level 2.
 * - In the second round, you complete 2 tasks of difficulty level 3.
 * - In the third round, you complete 3 tasks of difficulty level 4.
 * - In the fourth round, you complete 2 tasks of difficulty level 4.
 * It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
 * Example 2:
 *
 * Input: tasks = [2,3,3]
 * Output: -1
 * Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3 tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.
 *
 *
 * Constraints:
 *
 * 1 <= tasks.length <= 10^5
 * 1 <= tasks[i] <= 10^9
 */
public class MinimumRoundsToCompleteAllTasks {

    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4})); // 4
        System.out.println(minimumRounds(new int[]{2,3,3})); // -1
    }

    private static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskNumberToCounter = new HashMap<>();
        for (int task: tasks) {
            taskNumberToCounter.compute(task, (key, oldValue) -> oldValue == null ? 1 : ++oldValue);
        }
        for (int counter: taskNumberToCounter.values()) {
            if (counter == 1) {
                return -1;
            }
        }
        int res = 0;
        for (int counter: taskNumberToCounter.values()) {
            res += counter / 3;
            if (counter % 3 != 0) {
                // if counter % 3 = 1 or = 2 then we need to add 1 to the res. if = 1 then 3 + 1 -> 2 + 2. if 2 then add 1 operation for '2'
                res += 1;
            }
        }
        return res;
    }
}
