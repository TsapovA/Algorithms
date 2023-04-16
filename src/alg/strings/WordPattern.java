package alg.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-pattern/
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); // false
    }

    private static boolean wordPattern(String pattern, String s) {
        String[] splitted = s.split(" ");
        char[] charPattern = pattern.toCharArray();
        if (splitted.length != charPattern.length) {
            return false;
        }
        Map<Character, String> charToWord = new HashMap<>(splitted.length);
        Set<String> processedWords = new HashSet<>(splitted.length);

        for (int i = 0; i < pattern.length(); ++i) {
            if (charToWord.containsKey(charPattern[i])) {
                if (!charToWord.get(charPattern[i]).equals(splitted[i])) {
                    return false;
                }
            } else if (processedWords.contains(splitted[i])){
                return false;
            } else {
                charToWord.put(charPattern[i], splitted[i]);
                processedWords.add(splitted[i]);
            }
        }
        return true;
    }
}
