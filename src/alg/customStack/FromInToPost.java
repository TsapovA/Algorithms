package alg.customStack;

public class FromInToPost {

    private CharStack stack;
    private String in;
    private String out = "";

    public FromInToPost(String in) {
        this.in = in;
        this.stack = new CharStack(in.length());
    }

    public void doTransfer() {
        for (int i = 0; i < in.length(); ++i) {
            char ch = in.charAt(i);
            switch (ch) {
                case '+':
                case '-': {
                    getOper(ch, 1);
                    break;
                }
                case '*':
                case '/': {
                    getOper(ch, 2);
                    break;
                }

                case ')': {
                    getParen();
                    break;
                }

                case '(':{
                    stack.push(ch);
                    break;
                }

                default: {
                    out += ch;
                    break;
                }
            }
        }
        while (!stack.isEmpty()) {
            out += stack.pop();
        }
    }

    private void getOper(char ch, int priority) {
        while (!stack.isEmpty()) {
            char prevOp = stack.pop();

            if (prevOp == '(') {
                stack.push(prevOp);
                break;
            }
            int prevPriority;

            if (prevOp == '+' || prevOp == '-') {
                prevPriority = 1;
            } else {
                prevPriority = 2;
            }

            if (priority > prevPriority) {
                stack.push(prevOp);
                break;
            } else {
                out += prevOp;
            }
        }
        stack.push(ch);
    }

    private void getParen() {
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == '(') {
                break;
            }
            out += ch;
        }
    }

    public void showRes() {
        System.out.println("Result: " + out);
    }
}
