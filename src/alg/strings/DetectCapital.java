package alg.strings;

/**
 * https://leetcode.com/problems/detect-capital/
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "USA"
 * Output: true
 * Example 2:
 *
 * Input: word = "FlaG"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 */
public class DetectCapital {

    private static final byte ALL_CAPITALS = 1;
    private static final byte FIRST_CAPITAL = 1 << 1;
    private static final byte NO_CAPITALS = 1 << 2;

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA")); // true
        System.out.println(detectCapitalUse("FlaG")); // false
    }

    private static boolean detectCapitalUse(String word) {
        byte res = ALL_CAPITALS + FIRST_CAPITAL + NO_CAPITALS;
        for (int i = 0; i < word.length(); ++i) {
            if (Character.isUpperCase(word.charAt(i))) {
                res &= ~NO_CAPITALS;
                if (i != 0) {
                    res &= ~FIRST_CAPITAL;
                }
            } else {
                res &= ~ALL_CAPITALS;
            }
            if (res == 0) {
                return false;
            }
        }
        return res != 0;
    }
}
