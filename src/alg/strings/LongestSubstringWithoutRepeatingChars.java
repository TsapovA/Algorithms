package alg.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("abcde"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int length = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < length; ++r) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                res = Math.max(res, r - l);
                l = Math.max(l, map.get(ch) + 1);
            }
            map.put(ch, r);
        }
        res = Math.max(res, length - l);
        return res;
    }

    private static int lengthWithoutMapAndSet(String s) {
        int length = s.length();
        if (length == 0 || length == 1) {
            return length;
        }

        int startIndex = 0;
        int maxLength = 1;
        char[] chars = s.toCharArray();

        for (int i = 1; i < length; ++i) {
            for (int j = startIndex; j < i; ++j) {
                if (chars[i] == chars[j]) {
                    if (maxLength < i - startIndex) {
                        maxLength = i - startIndex;
                    }
                    j = startIndex;
                    startIndex = j + 1;
                }
            }
            if (i == length - 1 && maxLength < length - startIndex) {
                maxLength = length - startIndex;
            }
        }
        return maxLength;
    }
}
