package alg.linkedList;

import java.util.concurrent.ThreadLocalRandom;

public class SumDigitsReverseOrder {

    public static void main(String[] args) {
        SimpleNode node1 = init(3);
        System.out.println("Node1: ");
        SimpleNode.displayChains(node1);

        SimpleNode node2 = init(4);
        System.out.println("\nNode2: ");
        SimpleNode.displayChains(node2);

        SimpleNode res = summarize(node1, node2);
        System.out.println("\nSum: ");
        SimpleNode.displayChains(res);
    }

    static SimpleNode init(int numberOfDigits) {
        SimpleNode root = null;
        if (numberOfDigits > 0) {
            root = new SimpleNode(getRandDigit());
            SimpleNode current = root;
            for (int i = 1; i < numberOfDigits; ++i) {
                SimpleNode node = new SimpleNode(getRandDigit());
                current.next = node;
                current = node;
            }
        }
        return root;
    }

    private static int getRandDigit() {
        return ThreadLocalRandom.current().nextInt(0, 10);
    }

    private static SimpleNode summarize(SimpleNode node1, SimpleNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }
        return summarize(node1, node2, 0);
    }

    private static SimpleNode summarize(SimpleNode node1, SimpleNode node2, int additionalVal) {
        node1.val = node1.val + node2.val + additionalVal;

        int addVal = 0;
        if (node1.val > 9) {
            node1.val %= 10;
            ++addVal;
        }

        SimpleNode node1Next = node1.next;
        SimpleNode node2Next = node2.next;

        if (node1Next != null && node2Next != null) {
            summarize(node1Next, node2Next, addVal);
        } else if (node1Next == null) {
            sumWhenNode1reachEnd(node1, node2Next, addVal);
        } else {
            sumWhenNode2reachEnd(node1.next, addVal);
        }
        return node1;
    }

    private static void sumWhenNode1reachEnd(SimpleNode node1, SimpleNode node2, int additionalVal) {
        if (node2 == null) {
            return;
        }
        node1.next = node2;
        if (additionalVal != 0) {
            node2.val += additionalVal;
            if (node2.val > 9) {
                node2.val %= 10;
                sumWhenNode1reachEnd(node1, node2.next, 1);
            }
        }
    }

    private static void sumWhenNode2reachEnd(SimpleNode node1, int additionalVal) {
        if (node1 == null) {
            return;
        }
        if (additionalVal != 0) {
            node1.val += additionalVal;
            if (node1.val > 9) {
                node1.val %= 10;
                int addVal = 1;
                sumWhenNode2reachEnd(node1.next, addVal);
            }
        }
    }
}
