package alg.stack;

public class SortStack {
    private static final int STACK_SIZE = 20;

    public static void main(String[] args) {
        StackX stack = new StackX(STACK_SIZE);

        init(stack);
        displayStack(stack);

        StackX sortedStack = sortStack(stack);
        displayStack(sortedStack);
    }

    private static StackX sortStack(StackX stack) {
        StackX sortedStack = new StackX(stack.size());
        while (!stack.isEmpty()) {
            char temp = stack.pop();
            while (!sortedStack.isEmpty() && temp > sortedStack.peek()) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }

    private static void init(StackX stack) {
        for (int i = 'h'; i <= 'z'; i++) {
            stack.push((char)i);
        }
    }

    private static void displayStack(StackX stack) {
        StackX tempStack = new StackX(STACK_SIZE);
        while (!stack.isEmpty()) {
            char temp = stack.pop();
            System.out.print((int)temp + " ");
            tempStack.push(temp);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        System.out.println();
    }
}
