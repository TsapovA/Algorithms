package alg.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make
 * it equal to word2. For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1,
 * where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chain is "a","ba","bda","bdca".
 *
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 */
public class LongestStringChain {

    private static int res = 1;

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"})); // 4
        System.out.println(longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"})); // 5
    }

    private static int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < words.length; ++i) {
            perform(words, i, 1);
        }
        return res;
    }

    private static void perform(String[] words, int curStrIdx, int counter) {
        for (int i = curStrIdx + 1; i < words.length; ++i) {
            if (words[i].length() == words[curStrIdx].length() + 2) break;
            if (isPredecessor(words[curStrIdx], words[i])) {
                res = Math.max(res, counter + 1);
                perform(words, i, counter + 1);
            }
        }
    }

    private static boolean isPredecessor(String word1, String word2) {
        if (word2.length() - word1.length() != 1) return false;

        char[] word1Ch = word1.toCharArray();
        char[] word2Ch = word2.toCharArray();

        int counter = 0;
        boolean shouldStopCycle = false;

        for (int i = 0; i < word2.length(); ++i) {
            if (counter < word1.length() && word2Ch[i] == word1Ch[counter]) {
                counter++;
            } else {
                if (shouldStopCycle) return false;
                shouldStopCycle = true;
            }
        }
        return counter == word1.length();
    }
}
