package alg.strings;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse
 * of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 *
 *  Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 *
 *  Example 2:
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 *  Example 3:
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 *
 *  Example 4:
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {

    private static final int LOW_BRD = 10;
    private static final int HIGH_BRD = 26;
    private static final char ZERO = '0';

    public static void main(String[] args) {
        System.out.println(numDecodings("2101")); // 1
        System.out.println(numDecodings("10")); // 1
        System.out.println(numDecodings("12")); // 2
        System.out.println(numDecodings("226")); // 3
        System.out.println(numDecodings("0")); // 0
        System.out.println(numDecodings("06")); // 0
    }

    private static int numDecodings(String s) {
        char[] sChars = s.toCharArray();
        if (sChars[0] == ZERO) return 0;


        int[] dp = new int[s.length()];
        dp[0] = 1;

        if (s.length() > 1) {
            if (sChars[1] != ZERO) {
                dp[1] += dp[0];
            }
            int temp = Integer.parseInt(s.substring(0, 2));
            dp[1] += (temp >= LOW_BRD && temp <= HIGH_BRD) ? 1 : 0;
        }

        for (int i = 2; i < s.length(); ++i) {
            // one char case
            if (sChars[i] != ZERO) {
                dp[i] += dp[i - 1];
            }

            // two char case
            int twoCharVal = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoCharVal >= LOW_BRD && twoCharVal <= HIGH_BRD) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[dp.length - 1];
    }
}
