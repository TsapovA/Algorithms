package alg.linkedList;

import java.util.Stack;

public class isPalindrome {

    public static void main(String[] args) {
        SimpleNode node = init();
        System.out.print("Init: ");
        SimpleNode.displayChains(node);

        boolean flagPalindrome = isPalindrome(node);
        System.out.print("Is palindrome: " + flagPalindrome);
    }

    private static SimpleNode init() {
        SimpleNode node1 = new SimpleNode(1);
        SimpleNode node2 = new SimpleNode(2);
        SimpleNode node3 = new SimpleNode(3);
        SimpleNode node4 = new SimpleNode(4);
        SimpleNode node5 = new SimpleNode(2);
        SimpleNode node6 = new SimpleNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        return node1;
    }

    private static boolean isPalindrome(SimpleNode head) {
        if (head == null) {
            return true;
        }

        Stack<SimpleNode> stack = new Stack<>();
        SimpleNode slow = head;
        SimpleNode fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        // for odd number of elements
        if (fast != null) {
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            SimpleNode node = stack.pop();
            if (node.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
