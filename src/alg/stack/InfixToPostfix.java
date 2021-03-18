package alg.stack;


import java.util.Stack;

/**
 * Transform the expression from infix to postfix form.
 *
 * Infix expression: the expression of the form a op b. When an operator is in-between every pair of operands.
 * Postfix expression: the expression of the form a b op. When an operator is followed for every pair of operands.
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        char[] chars = exp.toCharArray();
        for (char ch: chars) {
            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else { // operand
                while (!stack.isEmpty() && getPrec(ch) <= getPrec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // A utility function to return precedence of a given operator Higher returned value means higher precedence
    private static int getPrec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
