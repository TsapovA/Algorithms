package alg.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^5
 * s consists of uppercase and lowercase English letters and digits.
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree")); // "eert" or "eetr"
        System.out.println(frequencySort("cccaaa")); // "aaaccc" or "cccaaa"
        System.out.println(frequencySort("Aabb")); // "bbAa"
    }

    private static String frequencySort(String s) {
        Map<Character, Integer> charCounter = new HashMap<>();
        for (char ch: s.toCharArray()) {
            charCounter.compute(ch, (__, v) -> v == null ? 1 : v + 1);
        }
        Map<Integer, String> resMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> entry: charCounter.entrySet()) {
            resMap.compute(entry.getValue(), (k, v) -> v == null ? String.valueOf(entry.getKey()) : v + entry.getKey());
        }
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Integer, String> entry: resMap.entrySet()) {
            for (char ch: entry.getValue().toCharArray()) {
                for (int i = 0; i < entry.getKey(); ++i) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
}
