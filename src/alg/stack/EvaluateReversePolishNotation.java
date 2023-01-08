package alg.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate
 * to a result, and there will not be any division by zero operation.
 *
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 10^4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"})); // 9
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"})); // 6
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); // 22
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for (String str: tokens) {
            if (str.length() > 1) {
                operands.push(Integer.valueOf(str));
                continue;
            }
            char ch = str.charAt(0);
            if (Character.isDigit(ch)) {
                operands.push(Integer.valueOf(str));
                continue;
            }
            switch(ch) {
                case '+' -> operands.push(operands.pop() + operands.pop());
                case '-' -> {
                    int firstOp = operands.pop();
                    int secondOp = operands.pop();
                    operands.push(secondOp - firstOp);
                }
                case '*' -> operands.push(operands.pop() * operands.pop());
                case '/' -> {
                    int firstOp = operands.pop();
                    int secondOp = operands.pop();
                    operands.push(secondOp / firstOp);
                }
                default -> throw new IllegalArgumentException();
            }
        }
        return operands.pop();
    }
}
