package alg.stack;

public class CustomInToPost {

    private StackX stack;
    private String input;
    private String out = "";

    public CustomInToPost(String inputStr) {
        input = inputStr;
        stack = new StackX(inputStr.length());
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
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

                case '(': {
                    stack.push(ch);
                    break;
                }

                case ')': {
                    getParen();
                    break;
                }
                default: {
                    out += ch;
                    break;
                }
            }
        }

        while (!stack.isEmpty()) {
            stack.displayStack("While ");
            out += stack.pop();
        }

        stack.displayStack("End  ");
        return out;
    }

    private void getOper(char ch, int newPriority) {
        while (!stack.isEmpty()) {
            char prevOp = stack.pop();
            if (prevOp == '(') {
                stack.push(prevOp);
                break;
            } else {
                int prevPriority;
                if (prevOp == '+' || prevOp == '-') {
                    prevPriority = 1;
                } else {
                    prevPriority = 2;
                }

                if (prevPriority >= newPriority) {
                    out += prevOp;
                } else {
                    stack.push(prevOp);
                    break;
                }
            }
        }
        stack.push(ch);
    }

    private void getParen() {
        while (!stack.isEmpty()) {
            char prev = stack.pop();
            if (prev == '(') {
                break;
            } else {
                out += prev;
            }
        }
    }
}
