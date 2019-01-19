package alg.linkedList;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        SimpleNode node = SumDigitsReverseOrder.init(5);
        System.out.print("Init: ");
        SimpleNode.displayChains(node);

        SimpleNode reverse = reverseStack(node);
        System.out.print("Reversed: ");
        SimpleNode.displayChains(reverse);
    }

    private static SimpleNode reverseStack(SimpleNode root) {
        Stack<SimpleNode> stack = new Stack<>();
        SimpleNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }


        SimpleNode reversedRoot = null;
        if (!stack.isEmpty()) {
            reversedRoot = stack.pop();

            SimpleNode curNode = reversedRoot;
            while (!stack.isEmpty()) {
                SimpleNode temp = stack.pop();
                curNode.next = temp;
                curNode = temp;
            }
            curNode.next = null;
        }
        return reversedRoot;
    }
}
