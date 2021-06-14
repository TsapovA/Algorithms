package alg.numbers;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 2^31 - 1
 */
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

    private static int mySqrt(int x) {
        int result = 0;
        int min = 1;
        int max = x;
        while (min <= max) {
            int temp = min / 2 + max / 2 + (min % 2 + max % 2) / 2;
            long res = (long) temp * temp;
            if (res < x) {
                result = temp;
                min = temp + 1;
            } else if (res > x) {
                max = temp - 1;
            } else return temp;
        }
        return result;
    }
}
