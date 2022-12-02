package alg.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description/
 *
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */
public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca")); // true
        System.out.println(closeStrings("a", "aa")); // false
        System.out.println(closeStrings("cabbba", "abbccc")); // true
    }

    private static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> first = new HashMap<>(word1.length());
        Map<Character, Integer> second = new HashMap<>(word1.length());
        for (char ch: word1.toCharArray()) {
            first.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        for (char ch: word2.toCharArray()) {
            second.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        if (!first.keySet().equals(second.keySet())) {
            return false;
        }
        Map<Integer, Integer> numberOfCharInclusionToCounter = new HashMap<>();
        for (int value: first.values()) {
            numberOfCharInclusionToCounter.compute(value, (__, v) -> v == null ? 1 : v + 1);
        }
        for (int value: second.values()) {
            numberOfCharInclusionToCounter.compute(value, (__, v) -> v == null ? -1 : v - 1);
        }
        for (int counter: numberOfCharInclusionToCounter.values()) {
            if (counter != 0) {
                return false;
            }
        }
        return true;
    }
}
