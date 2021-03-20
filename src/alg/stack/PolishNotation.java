package alg.stack;

import java.util.*;

/**
 * Prefix notation is a notation for writing arithmetic expressions in which the operands appear after their operators.
 * There are no precedence rules to learn.
 *
 * Operands are real numbers in real digits. Permitted operators: +,-, *, /, ^(exponentiation)
 * Blanks are NOT permitted in expression. Parenthesis are permitted
 *
 * Example:
 *
 * Postfix: +54
 * Output: 9
 * Explanation: Infix expression of the above prefix is:  5 + 4 which resolves to 9
 *
 * Postfix: -/*2*5+3652
 * Output: 16
 * Explanation: Infix expression of above prefix is:  2 * (5 *(3+6))/5-2 which resolves to 16
 */
public class PolishNotation {

    public static void main(String[] args) {
        System.out.println(calc("+54")); //9
        System.out.println(calc("-/*2*5+3652")); //16
    }

    private static double calc(String str) {
        Stack<Double> stack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; --i) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                double first = stack.pop();
                double second = stack.pop();
                stack.push(evaluate(first, second, ch));
            } else {
                // operand
                stack.push((double)(ch - '0'));
            }
        }
        return stack.pop();
    }

    private static double evaluate(double first, double second, char operator) {
        switch(operator) {
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second;
            case '/': {
                if (second == 0) {
                    throw new IllegalArgumentException();
                }
                return first / second;
            }
            case '^': return Math.pow(first, second);
            default: throw new IllegalArgumentException();
        }
    }
}
