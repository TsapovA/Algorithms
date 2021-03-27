package alg.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
 * in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 *
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^4
 * s consists of lower-case English letters.
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] consists of lower-case English letters.
 */
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        Map<String, Integer> wordsToCheck = new HashMap<>(words.length);
        for (String word: words) {
            // check equal words
            wordsToCheck.put(word, wordsToCheck.getOrDefault(word, 0) + 1);
        }

        int sLength = s.length();
        int strLengthMinusWordLength = sLength - wordLength;
        List<Integer> results = new ArrayList<>();
        for (int startIdx = 0; startIdx <= sLength - wordLength * words.length; ++startIdx) {
            Map<String, Integer> tempMap = new HashMap<>(wordsToCheck);

            for (int idx = startIdx, attemptCounter = 0; attemptCounter < words.length && idx <= strLengthMinusWordLength; idx += wordLength, ++attemptCounter) {
                String substring = s.substring(idx, idx + wordLength);
                if (tempMap.containsKey(substring)) {
                    if (tempMap.get(substring) == 1) {
                        tempMap.remove(substring);
                    } else {
                        tempMap.put(substring, tempMap.get(substring) - 1);
                    }
                } else {
                    break;
                }
            }
            if (tempMap.isEmpty()) {
                results.add(startIdx);
            }
        }
        return results;
    }
}
