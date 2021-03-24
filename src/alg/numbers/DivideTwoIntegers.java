package alg.numbers;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * 
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
 * For this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 * 
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 *
 * Example 3:
 * Input: dividend = 0, divisor = 1
 * Output: 0
 *
 * Example 4:
 * Input: dividend = 1, divisor = 1
 * Output: 1
 *
 * Constraints:
 * 
 * -2^31 <= dividend, divisor <= 2^31 - 1
 * divisor != 0
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(2147483647, 1));
        System.out.println(divide(-2147483648, 1));
    }

    /**
     * Time complexity: O(log N^2)
     * Space complexity: O(1)
     *
     * while we can subtract the divisor from dividend
     * - double the divisor and check the sign
     * - increment the count
     * - check again
     * - add count to result
     * - subtract that variable from dividend
     */
    private static int divide(int dividend, int divisor) {
        // because |Integer.MAX_VALUE| < |Integer.MIN_VALUE| by 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean sign = (dividend >= 0) == (divisor >= 0);

        // long for the case when dividend = Integer.MIN_VALUE or divisor = Integer.MIN_VALUE
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int result = 0;
        while (dividendL >= divisorL) {
            int counter = 0;

            while (true) {
                long temp = divisorL << 1 << counter;
                if (temp > 0 && dividendL >= temp) {
                    ++counter;
                } else break;
            }

            result += 1 << counter;
            dividendL -= divisorL << counter;
        }

        return sign ? result : -result;
    }
}
