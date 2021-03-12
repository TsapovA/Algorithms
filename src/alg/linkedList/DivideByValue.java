package alg.linkedList;

import java.util.concurrent.ThreadLocalRandom;

public class DivideByValue {

    public static void main(String[] args) {
        Node init = init();

        int divider = ThreadLocalRandom.current().nextInt(8, 12);
        System.out.println("Divider is: " + divider);
        Node.displayLinkedList(init);

        init = divideByValue(init, divider);
        System.out.println("\nAfter dividing:");
        Node.displayLinkedList(init);
    }

    private static Node init() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Node node1 = new Node(random.nextInt(10, 20), random.nextInt(1, 20));
        Node node2 = new Node(random.nextInt(10, 20), random.nextInt(1, 20));
        Node node3 = new Node(random.nextInt(5, 10), random.nextInt(1, 20));
        Node node4 = new Node(random.nextInt(1, 8), random.nextInt(1, 20));
        Node node5 = new Node(random.nextInt(1, 8), random.nextInt(1, 20));

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    private static Node divideByValue(Node init, int divider) {
        Node prev = init.next;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.key < divider) {
                prev.next = cur.next;
                init = pushToHead(init, cur);
                cur = prev.next;
            } else {
                prev = prev.next;
                cur = prev.next;
            }
        }
        return init;
    }

    private static Node pushToHead(Node prevHead, Node newHead) {
        newHead.next = prevHead;
        return newHead;
    }

    private static class Node {

        public final int key;
        public final int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public static void displayLinkedList(Node init) {
            Node temp = init;
            while (temp != null) {
                System.out.print(temp.key + " -> ");
                temp = temp.next;
            }
        }
    }
}
