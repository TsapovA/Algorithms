package alg.customStack;

public class CalcPost {

    IntStack stack;
    String in;
    String out = "";

    public CalcPost(String input) {
        in = input;
        stack = new IntStack(in.length());
    }

    public void calc() {
        for (int i = 0; i < in.length(); ++i) {
            char ch = in.charAt(i);
            if (isNumber(ch)) {
                // using char code value for '0' to get correct int value;
                stack.push(ch - '0');
            }
            else if (isOper(ch)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (ch){
                    case '+': {
                        stack.push(num1 + num2);
                        break;
                    }
                    case '-': {
                        stack.push(num1 - num2);
                        break;
                    }
                    case '*': {
                        stack.push(num1 * num2);
                        break;
                    }
                    case '/': {
                        stack.push(num1 / num2);
                        break;
                    }
                }
            }
        }
        out = String.valueOf(stack.pop());
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public void showRes() {
        System.out.println("Result: " + out);
    }
}
