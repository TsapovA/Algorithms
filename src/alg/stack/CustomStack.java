package alg.stack;

public class CustomStack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public CustomStack(int strLength) {
        maxSize = strLength;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size(){
        return top + 1;
    }

    public char peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.println(s);
        System.out.println("Stack (bottom --> top): ");
        for (int j = 0; j < size(); j++) {
            System.out.println( peekN(j) );
            System.out.println(' ');
        }
        System.out.println("");
    }
}
