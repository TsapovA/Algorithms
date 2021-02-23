package alg.numbers;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 *
 * Input: x = -101
 * Output: false
 *
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1111));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int number = 0;
        while (number < x) {
            number = number * 10 + x % 10;
            x /= 10;
        }

        return number == x || number / 10 == x;
    }
}
