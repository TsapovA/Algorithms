package alg.arrays;

/**
 * https://leetcode.com/problems/maximum-ice-cream-bars/
 *
 * It is a sweltering summer day, and a boy wants to buy some ice cream bars.
 *
 * At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of
 * the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream
 * bars as possible.
 *
 * Return the maximum number of ice cream bars the boy can buy with coins coins.
 *
 * Note: The boy can buy the ice cream bars in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: costs = [1,3,2,4,1], coins = 7
 * Output: 4
 * Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
 * Example 2:
 *
 * Input: costs = [10,6,8,7,7,8], coins = 5
 * Output: 0
 * Explanation: The boy cannot afford any of the ice cream bars.
 * Example 3:
 *
 * Input: costs = [1,6,3,1,2,5], coins = 20
 * Output: 6
 * Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.
 *
 *
 * Constraints:
 *
 * costs.length == n
 * 1 <= n <= 10^5
 * 1 <= costs[i] <= 10^5
 * 1 <= coins <= 10^8
 */
public class MaximumIceCreamBars {

    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1,3,2,4,1}, 7)); // 4
        System.out.println(maxIceCream(new int[]{10,6,8,7,7,8}, 5)); // 0
        System.out.println(maxIceCream(new int[]{1,6,3,1,2,5}, 20)); // 6
    }

    private static int maxIceCream(int[] costs, int coins) {
        // counting sort with range [0; coins + 1], where (coins + 1) for all values > coins
        int[] countingArr = new int[coins + 2];
        for (int cost: costs) {
            if (cost <= coins) {
                countingArr[cost]++;
            } else {
                // all values above 'coins'
                countingArr[coins + 1]++;
            }
        }
        int res = 0;
        boolean outOfMoney = false;
        for (int i = 0; i < countingArr.length; ++i) {
            while (countingArr[i]-- > 0) {
                coins -= i;
                if (coins < 0) {
                    outOfMoney = true;
                    break;
                }
                ++res;
            }
            if (outOfMoney) {
                break;
            }
        }
        return res;
    }
}
