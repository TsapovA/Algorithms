package alg.other;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^(-2) = 1/2^2 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= xn <= 10^4
 */
public class Pow {

    public static void main(String[] args) {
        /*System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
        System.out.println(myPow(-2.0, 5));
        System.out.println(myPow(2.0, -2147483648));
        System.out.println(myPow(-1.0, 2147483647));*/
        System.out.println(myPow(1.00012, 1024));
    }

    private static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;
        if (x == - 1) return n % 2 == 0 ? 1 : -1;
        // just for optimization
        if (n > 1 && n % 1024 == 0) {
            double newX = x;
            for (int i = 0; i < 10; ++i) {
                newX *= newX;
            }
            return myPow(newX, n / 1024);
        };
        if (n > 1 && n % 2 == 0) return myPow(x * x, n / 2);
        if (n < 0) {
            return n % 2 == 0 ?
                myPow(1.0 / (x * x), (n / 2) * (-1)) :
                myPow(1.0 / x, -n);
        }
        double result = 1.0;
        while (n > 0) {
            result *= x;
            --n;
        }
        return result;
    }
}
