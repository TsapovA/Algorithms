package alg.numbers;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Examples:
 *
 * Input: x = 123
 * Output: 321
 *
 * Input: x = -123
 * Output: -321
 *
 * Input: x = 120
 * Output: 21
 *
 * Input: x = 0
 * Output: 0
 *
 *
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 */

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-1234));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));
    }

    private static long reverse(int x) {
        int intMaxNumberOfDigits = 0;
        int i = Integer.MAX_VALUE;
        while (i != 0) {
            ++intMaxNumberOfDigits;
            i /= 10;
        }
        int intMaxLastDigit = Integer.MAX_VALUE % 10;
        int intMinLastDigit = -1 * (Integer.MIN_VALUE % 10);
        int intMaxDividedByTen = Integer.MAX_VALUE / 10;
        int intMinDividedByTen = Integer.MIN_VALUE / 10;
        int res = 0;
        int currentNumberOfDigits = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (res > intMaxDividedByTen || (currentNumberOfDigits == intMaxNumberOfDigits && pop > intMaxLastDigit)) {
                return 0;
            }

            if (res < intMinDividedByTen || (currentNumberOfDigits == intMaxNumberOfDigits && pop < intMinLastDigit)) {
                return 0;
            }
            res *= 10;
            res += pop;
            ++currentNumberOfDigits;
        }
        return res;
    }
}
