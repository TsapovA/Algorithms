package alg.strings;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 *
 * Constraints:
 *
 *     1 <= haystack.length, needle.length <= 104
 *     haystack and needle consist of only lowercase English characters.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    private static int strStr(String haystack, String needle) {
        char[] haystackCh = haystack.toCharArray();
        char[] needleCh = needle.toCharArray();
        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            if (haystackCh[i] == needleCh[0]) {
                boolean found = true;
                int j = 1;
                while (j < needleCh.length) {
                    if (haystackCh[i + j] != needleCh[j]) {
                        found = false;
                        break;
                    }
                    ++j;
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }
}
