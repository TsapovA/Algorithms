package alg.numbers;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    private static int climbStairs(int n) {
        int[] col = new int[n];
        col[0] = 1;
        if (n > 1) col[1] = 2;

        for (int i = 2; i < n; ++i) {
            col[i] = col[i - 1] + col[i - 2];
        }
        return col[n - 1];
    }

    private static int climbStairsUsingFibonacci(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 2;
        int third = 0;
        int counter = n - 2;

        do {
            third = first + second;
            first = second;
            second = third;
            --counter;
        } while (counter > 0);
        return third;
    }
}
