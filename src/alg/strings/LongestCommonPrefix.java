package alg.strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Math.min(strs[0].length(), Integer.MAX_VALUE);
        for (int i = 1; i < strs.length; ++i) {
            minLen = Math.min(minLen, strs[i].length());
        }

        int min = 0;
        int max = minLen;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (isCommonPrefix(strs, mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return strs[0].substring(0, (min + max) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; ++i) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
