package alg.strings;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("babad")); // "bab" or "aba"
        System.out.println(getLongestPalindrome("cbbd"));  // "bb"
        System.out.println(getLongestPalindrome("a"));     // "a"
        System.out.println(getLongestPalindrome("ac"));    // "a"
    }

    private static String getLongestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int leftIndex = 0;
        int rightIndex = 0;
        // It's possible to use a single formula to determine left/right indexes but it doesn't a significant part of the task
        for (int i = 0; i < s.length(); ++i) {
            int len = getMaxPalindromeLength(s, i, i);
            if (rightIndex - leftIndex < len) {
                leftIndex = i - len / 2;
                rightIndex = i + len / 2;
            }

            len = getMaxPalindromeLength(s, i, i + 1);
            if (rightIndex - leftIndex < len) {
                leftIndex = i - len / 2;
                rightIndex = i + (len + 1) / 2;
            }
        }
        return s.substring(leftIndex, rightIndex + 1);
    }

    private static int getMaxPalindromeLength(String str, int leftIdx, int rightIdx) {
        int left = leftIdx;
        int right = rightIdx;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 2;
    }
}
