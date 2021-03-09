package alg.strings;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * "2" -> "abc"
 * "3" -> "def"
 * "4" -> "ghi"
 * "5" -> "jkl"
 * "6" -> "mno"
 * "7" -> "pqrs"
 * "8" -> "tuv"
 * "9" -> "wxyz"
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfPhoneNumber {

    private static char[][] letters = new char[8][];
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("239"));
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        for (char ch: digits.toCharArray()) {
            if (ch < '2' || ch > '9') {
                throw new IllegalArgumentException();
            }
        }

        letters[0] = new char[]{'a', 'b', 'c'};
        letters[1] = new char[]{'d', 'e', 'f'};
        letters[2] = new char[]{'g', 'h', 'i'};
        letters[3] = new char[]{'j', 'k', 'l'};
        letters[4] = new char[]{'m', 'n', 'o'};
        letters[5] = new char[]{'p', 'q', 'r', 's'};
        letters[6] = new char[]{'t', 'u', 'v'};
        letters[7] = new char[]{'w', 'x', 'y', 'z'};

        perform("", digits.toCharArray(), 0);
        return result;
    }

    private static void perform(String currentString, char[] digits, int index) {
         if (index == digits.length) {
             result.add(currentString);
             return;
         }
         char digit = digits[index];
         char[] lettersToIndex = letters[digit - '2'];
         for (char ch: lettersToIndex) {
             perform(currentString + ch, digits, index + 1);
         }
    }
}
