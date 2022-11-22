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
        System.out.println(infixToPostfix2(exp));
    }

    private static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        char[] chars = exp.toCharArray();
        for (char ch: chars) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else { // operand
                while (!stack.isEmpty() && getPrec(ch) <= getPrec(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    // A utility function to return precedence of a given operator Higher returned value means higher precedence
    private static int getPrec(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    private static String infixToPostfix2(String str) {
        StringBuilder resBuilder = new StringBuilder();
        StackX<Character> stack = new StackX<>(str.length());
        char[] chars = str.toCharArray();
        for (char ch: chars) {
            if (Character.isLetterOrDigit(ch)) {
                resBuilder.append(ch);
                continue;
            }
            switch (ch) {
                case '(' -> stack.push(ch);
                case ')' -> extractOp(stack, resBuilder);
                default -> operator(stack, resBuilder, ch);
            }
        }
        while (!stack.isEmpty()) {
            resBuilder.append(stack.pop());
        }
        return resBuilder.toString();
    }

    private static void operator(StackX<Character> stack, StringBuilder resBuilder, char ch) {
        int priority = getPriority(ch);
        while (!stack.isEmpty()) {
            char prev = stack.pop();
            if (prev == '(') {
                stack.push(prev);
                break;
            } else if (getPriority(prev) < priority) {
                stack.push(prev);
                break;
            } else {
                resBuilder.append(prev);
            }
        }
        stack.push(ch);
    }

    private static void extractOp(StackX<Character> stack, StringBuilder resBuilder) {
        while (!stack.isEmpty()) {
            Character prev = stack.pop();
            if (prev == '(') {
                return;
            }
            resBuilder.append(prev);
        }
    }

    private static int getPriority(char ch) {
        return switch(ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> throw new IllegalArgumentException("char=" + ch);
        };
    }

    private static class StackX<T> {

        private final int size;
        private final Object[] array;
        private int top = -1;

        public StackX(int size) {
            this.size = size;
            this.array = new Object[size];
        }

        public void push(T t) {
            array[++top] = t;
        }

        public T pop() {
            Object res = array[top];
            array[top] = null;
            --top;
            return (T) res;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}
