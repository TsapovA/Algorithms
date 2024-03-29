package alg.strings;

import java.util.Set;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 *
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first
 * half and b be the second half. Two strings are alike if they have the same number of vowels
 * ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 * Return true if a and b are alike. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * Example 2:
 *
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 1000
 * s.length is even.
 * s consists of uppercase and lowercase letters.
 */
public class DetermineIfStringHalvesAreAlike {

    private static final Set<Character> CHARS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book")); // true
        System.out.println(halvesAreAlike("textbook")); // false
    }

    private static boolean halvesAreAlike(String s) {
        int edgeValue = s.length() / 2;
        int counter = 0;
        char[] charAr = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (CHARS.contains(charAr[i])) {
                if (i < edgeValue) {
                    ++counter;
                } else {
                    --counter;
                }
            }
        }

        return counter == 0;
    }
}
