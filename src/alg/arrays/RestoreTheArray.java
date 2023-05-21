package alg.arrays;

/**
 * https://leetcode.com/problems/restore-the-array/
 *
 * A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is
 * printed as a string of digits s and all we know is that all integers in the array were in the range [1, k] and
 * there are no leading zeros in the array.
 *
 * Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the
 * mentioned program. Since the answer may be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1000", k = 10000
 * Output: 1
 * Explanation: The only possible array is [1000]
 *
 * Example 2:
 *
 * Input: s = "1000", k = 10
 * Output: 0
 * Explanation: There cannot be an array that was printed this way and has all integer >= 1 and <= 10.
 *
 * Example 3:
 *
 * Input: s = "1317", k = 2000
 * Output: 8
 * Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 105
 *     s consists of only digits and does not contain leading zeros.
 *     1 <= k <= 109
 */
public class RestoreTheArray {

    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println(numberOfArrays("1000", 10000)); // 1
        System.out.println(numberOfArrays("1000", 10)); // 0
        System.out.println(numberOfArrays("1317", 2000)); // 8
    }

    private static int numberOfArrays(String s, int k) {
        counter = 0;
        step(s, 0, k);
        return counter;
    }

    // Too slow decision!
    private static boolean step(String s, int idx, int k) {
        if (idx >= s.length()) {
            return true;
        }
        if (s.charAt(idx) == '0') {
            return false;
        }

        boolean res = false;
        for (int i = idx; i < s.length(); ++i) {
            int value = Integer.parseInt(s.substring(idx, i + 1));
            if (value > k) {
                return res;
            }
            res = step(s, i + 1, k);
            if (res && i == s.length() - 1) {
                ++counter;
            }
        }
        return res;
    }
}
