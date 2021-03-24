package alg.strings;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= haystack.length, needle.length <= 5 * 10^4
 * haystack and needle consist of only lower-case English characters.
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("a", "a"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        char[] haystackCh = haystack.toCharArray();
        char[] needleCh = needle.toCharArray();

        for(int i = 0; i < haystackCh.length; ++i) {
            if (haystackCh.length - i < needleCh.length) {
                return -1;
            }
            if (haystackCh[i] == needleCh[0]) {
                boolean isEqual = true;
                for (int j = i + 1, k = 1; k < needleCh.length; ++j, ++k) {
                    if (haystackCh[j] != needleCh[k]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) return i;
            }
        }
        return -1;
    }
}
