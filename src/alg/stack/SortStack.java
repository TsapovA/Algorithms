package alg.stack;

public class SortStack {
    private static final int STACK_SIZE = 20;

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(STACK_SIZE);

        init(stack);
        displayStack(stack);

        CustomStack sortedStack = sortStack(stack);
        displayStack(sortedStack);
    }

    private static CustomStack sortStack(CustomStack stack) {
        CustomStack sortedStack = new CustomStack(stack.size());
        while (!stack.isEmpty()) {
            char temp = stack.pop();
            while (!sortedStack.isEmpty() && temp > sortedStack.peek()) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }

    private static void init(CustomStack stack) {
        for (int i = 'h'; i <= 'z'; i++) {
            stack.push((char)i);
        }
    }

    private static void displayStack(CustomStack stack) {
        CustomStack tempStack = new CustomStack(STACK_SIZE);
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
