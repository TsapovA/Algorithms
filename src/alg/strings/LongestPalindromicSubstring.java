package alg.strings;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
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

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("babad")); // "bab" or "aba"
        System.out.println(getLongestPalindrome2("babad")); // "bab" or "aba"

        System.out.println(getLongestPalindrome("cbbd"));  // "bb"
        System.out.println(getLongestPalindrome2("cbbd"));  // "bb"

        System.out.println(getLongestPalindrome("a"));     // "a"
        System.out.println(getLongestPalindrome2("a"));     // "a"

        System.out.println(getLongestPalindrome("ac"));    // "a"
        System.out.println(getLongestPalindrome2("ac"));    // "a"
    }

    private static String getLongestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int leftIndex = 0;
        int rightIndex = 0;
        // It's possible to use a single formula to determine left/right indexes but it doesn't a significant part of the task
        for (int center = 0; center < s.length(); ++center) {
            // check case with center element
            int len = getMaxPalindromeLength(s, center, center);
            if (rightIndex - leftIndex < len) {
                leftIndex = center - len / 2;
                rightIndex = center + len / 2;
            }

            //check case without center element
            len = getMaxPalindromeLength(s, center, center + 1);
            if (rightIndex - leftIndex < len) {
                leftIndex = center - len / 2;
                rightIndex = center + (len + 1) / 2;
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

    //------------------

    private static String getLongestPalindrome2(String s) {
        if (s.length() == 1) {
            return s;
        }
        int leftIdx = 0;
        int len = 1;

        for (int i = 0; i < s.length(); ++i) {
            int curLen = getMaxLength(s, i, i);
            if (curLen > len) {
                len = curLen;
                leftIdx = i - curLen / 2;
            }

            curLen = getMaxLength(s, i, i + 1);
            if (curLen > len) {
                len = curLen;
                leftIdx = i - (curLen - 1) / 2;
            }
        }
        return s.substring(leftIdx, leftIdx + len);
    }

    private static int getMaxLength(String s, int leftIdx, int rightIdx) {
        int i = leftIdx, j = rightIdx;
        while(i >=0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return Math.max(j - i - 1, 0);
            }
            --i;
            ++j;
        }
        return j - i - 1;
    }
}
