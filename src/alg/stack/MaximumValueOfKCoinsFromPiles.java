package alg.stack;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
 *
 * solution with explanation: https://www.youtube.com/watch?v=ZRdEd_eun8g
 *
 * There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.
 *
 * In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.
 *
 * Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom,
 * and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly
 * k coins optimally.
 *
 *
 * Example 1:
 *
 * Input: piles = [[1,100,3],[7,8,9]], k = 2
 * Output: 101
 * Explanation:
 * The above diagram shows the different ways we can choose k coins.
 * The maximum total we can obtain is 101.
 *
 * Example 2:
 *
 * Input: piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
 * Output: 706
 * Explanation:
 * The maximum total can be obtained if we choose all coins from the last pile.
 *
 *
 *
 * Constraints:
 *
 *     n == piles.length
 *     1 <= n <= 1000
 *     1 <= piles[i][j] <= 105
 *     1 <= k <= sum(piles[i].length) <= 2000
 */
public class MaximumValueOfKCoinsFromPiles {

    public static void main(String[] args) {
        System.out.println(maxValueOfCoins(Arrays.asList(Arrays.asList(1,100,3), Arrays.asList(7,8,9)), 2)); // 101
        /*
        System.out.println(maxValueOfCoins(Arrays.asList(
            Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100),
            Arrays.asList(100), Arrays.asList(1, 1, 1, 1, 1, 1, 700)), 7)); // 706
         */
    }

    private static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1]; // for memoization
        return dfs(0, k, piles, dp);
    }

    private static int dfs(int pileIdx, int coinsLeft, List<List<Integer>> piles, int[][] dp) {
        if (pileIdx == piles.size() || coinsLeft == 0) {
            return 0;
        }

        // already computed
        if (dp[pileIdx][coinsLeft] > 0) {
            return dp[pileIdx][coinsLeft];
        }

        // skip current pile (with idx = pileIdx)
        int res = dfs(pileIdx + 1, coinsLeft, piles, dp);
        int cur = 0;

        // working with the current pile
        for (int j = 0; j < Math.min(piles.get(pileIdx).size(), coinsLeft); ++j) {
            cur += piles.get(pileIdx).get(j);
            // get one coin from the current pile and move to the next pile. (j + 1) because j starts with 0;
            res = Math.max(res, cur + dfs(pileIdx + 1, coinsLeft - (j + 1), piles, dp));
        }
        dp[pileIdx][coinsLeft] = res;
        return res;
    }
}
