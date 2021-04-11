package alg.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 *
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 *
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    private static int res;

    public static void main(String[] args) {
        System.out.println(maxLengthBitManipulation(Arrays.asList("un", "iq", "ue"))); // 4
        System.out.println(maxLengthBitManipulation((Arrays.asList("cha", "r", "act", "ers")))); //6
        System.out.println(maxLengthBitManipulation((Arrays.asList("abcdefghijklmnopqrstuvwxyz")))); // 26
        System.out.println(maxLengthBitManipulation((Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")))); // 16
    }

    private static int maxLength(List<String> arr) {
        res = 0;
        backtrack(0, arr, new HashSet<Character>());
        return res;
    }

    private static void backtrack(int idx, List<String> arr, Set<Character> set) {
        for (int i = idx; i < arr.size(); ++i) {
            char[] curStrChars = arr.get(i).toCharArray();
            Set<Character> curStrCharSet = new HashSet<>();
            int j = 0;

            for (; j < curStrChars.length; ++j) {
                if (!curStrCharSet.add(curStrChars[j])) break;
                if (set.contains(curStrChars[j])) break;
            }
            if (j == curStrChars.length) {
                for (int k = 0; k < curStrChars.length; ++k) set.add(curStrChars[k]);
                res = Math.max(res, set.size());
                // check 2 cases: with chars from current string and without it, because the next word may contain
                // more characters and an overall result will be greater
                backtrack( i + 1, arr, set);
                for (int l = 0; l < curStrChars.length; ++l) set.remove(curStrChars[l]);
            }
        }
    }

    // using bit manipulation
    // check how it's worked
    private static int maxLengthBitManipulation(List<String> arr) {
        int[] res = {0};
        backtrackingBitManipulation(0, arr, 0, res);
        return res[0];
    }
    private static void backtrackingBitManipulation(int prefix, List<String> arr, int idx, int[] res) {
        for (int i = idx; i < arr.size(); i++) {
            int dup = 0, a = 0;
            for (char c : arr.get(i).toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= (1 << (c - 'a'));
            }
            if (dup > 0 || (prefix & a) > 0) continue;
            res[0] = Math.max(res[0], Integer.bitCount(prefix | a));
            backtrackingBitManipulation(prefix | a, arr, i + 1, res);
        }
    }
}
