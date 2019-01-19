package alg.linkedList;

import static alg.linkedList.SumDigitsReverseOrder.init;

public class SumDigitsNormalOrder {

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

    private static SimpleNode summarize(SimpleNode node1, SimpleNode node2) {
        int node1Length = length(node1);
        int node2Length = length(node2);
        if (node1Length > node2Length) {
            node2 = putNodesToHead(node2, node2Length, node1Length);
        } else {
            node1 = putNodesToHead(node1, node1Length, node2Length);
        }
        return sumVal(node1, node2).node;
    }

    private static PartialSum sumVal(SimpleNode node1, SimpleNode node2) {
        // (node1.length) is equal to (node2.Length)
        if (node1 == null) {
            return new PartialSum(null, 0);
        } else {
            SimpleNode curNode = new SimpleNode(0);
            PartialSum next = sumVal(node1.next, node2.next);

            int nodeVal = node1.val + node2.val + next.val;
            int extraVal = 0;

            if (nodeVal > 9) {
                extraVal = 1;
                nodeVal %= 10;
            }

            curNode.val = nodeVal;
            curNode.next = next.node;
            return new PartialSum(curNode, extraVal);
        }
    }

    private static int length(SimpleNode node) {
        int length = 0;
        while (node != null) {
            ++length;
            node = node.next;
        }
        return length;
    }

    private static SimpleNode putNodesToHead(SimpleNode node, int nodeLength, int desiredLength) {
        SimpleNode curNode = node;

        for (int i = nodeLength; i < desiredLength; ++i ) {
            curNode = putZeroToHead(node);
        }
        return curNode;
    }

    private static SimpleNode putZeroToHead(SimpleNode node) {
        SimpleNode zeroNode = new SimpleNode(0);
        zeroNode.next = node;
        return zeroNode;
    }

    private static class PartialSum {
        public SimpleNode node;
        public int val;

        public PartialSum(SimpleNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }
}
