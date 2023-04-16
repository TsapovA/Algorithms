package alg.strings;

/**
 * https://leetcode.com/problems/string-compression/
 * <p>
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * <p>
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * <p>
 * Example 2:
 * <p>
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * <p>
 * Example 3:
 * <p>
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'b', 'c'})); // 3
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'})); // 6
        System.out.println(compress(new char[]{'a'})); // 1
        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'})); // 4
    }

    private static int compress(char[] chars) {
        int newIdx = 0;
        int seqCounter = 1;
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            while (i < chars.length - 1 && chars[i + 1] == ch) {
                ++seqCounter;
                ++i;
            }
            chars[newIdx++] = ch;
            if (seqCounter > 1) {
                int numberOfDigits = getNumberOfDigits(seqCounter);

                int divider = (int) Math.pow(10, numberOfDigits - 1);
                while (divider > 0) {
                    chars[newIdx++] = (char) ('0' + seqCounter / divider % 10);
                    divider /= 10;
                }
                seqCounter = 1;
            }
            ++i;
        }

        return newIdx;
    }

    private static int getNumberOfDigits(int n) {
        int res = 1;
        int divider = 10;
        while (n / divider > 0) {
            divider *= 10;
            ++res;
        }
        return res;
    }
}
