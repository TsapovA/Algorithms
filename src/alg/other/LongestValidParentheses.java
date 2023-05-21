package alg.other;


import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed)
 * parentheses substring.
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     0 <= s.length <= 3 * 104
 *     s[i] is '(', or ')'.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); // 2
        System.out.println(longestValidParentheses(")()())")); // 4
        System.out.println(longestValidParentheses("")); // 0
    }

    private static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<InnerElement> stack = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (chars[i] == '(') {
                stack.push(new InnerElement((byte) 0, (short) i));
                continue;
            }

            if (chars[i] == ')') {
                if (stack.isEmpty() || stack.peek().element() == 1) {
                    stack.push(new InnerElement((byte) 1, (short) i));
                    continue;
                }

                stack.pop();
                int prevElementIdx = stack.isEmpty() ? -1 : stack.peek().idx();
                res = Math.max(res, i - prevElementIdx);
            }
        }
        return res;
    }

    private record InnerElement(byte element, short idx) {
    }
}
