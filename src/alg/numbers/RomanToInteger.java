package alg.numbers;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Example 2:
 *
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 *
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt(null));
        System.out.println(romanToInt(""));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        // map may be used instead
        int[] ints = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romans = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        char[] chars = s.toCharArray();
        int result = 0;

        for(int i = chars.length - 1; i >= 0; --i) {
            if (i > 0) {
                int idx = findIndex(romans, chars[i - 1] + String.valueOf(chars[i]));
                if (idx != -1) {
                    result += ints[idx];
                    --i;
                } else {
                    result += ints[findIndex(romans, String.valueOf(chars[i]))];
                }
            } else {
                result += ints[findIndex(romans, String.valueOf(chars[i]))];
            }
        }
        return result;
    }

    private static int findIndex(String[] mass, String s) {
        if (s == null || mass == null) {
            return -1;
        }
        for (int i = 0; i < mass.length; ++i) {
            if (s.equals(mass[i])) {
                return i;
            }
        }
        return -1;
    }
}
