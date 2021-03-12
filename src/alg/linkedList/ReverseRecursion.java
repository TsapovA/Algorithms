package alg.linkedList;

public class ReverseRecursion {

    public static void main(String[] args) {
        SimpleNode node = SumDigitsReverseOrder.init(5);
        System.out.print("Init: ");
        SimpleNode.displayChains(node);

        SimpleNode reverse = reverse(node);
        System.out.print("Reversed: ");
        SimpleNode.displayChains(reverse);
    }

    private static SimpleNode reverse(SimpleNode head) {
        if (head == null) {
            return null;
        }
        HeadAndTail reversedHT = new HeadAndTail(null, head);
        reverseTwo(head, head.next, reversedHT);
        head.next = null;
        return reversedHT.head;
    }

    private static SimpleNode reverseTwo(SimpleNode prev, SimpleNode cur, HeadAndTail ht) {
        if (cur != null) {
            SimpleNode node = reverseTwo(cur, cur.next, ht);
            node.next = prev;
            return prev;
        } else {
            ht.head = prev;
            return prev;
        }
    }

    private static class HeadAndTail {

        public SimpleNode head;
        public SimpleNode tail;

        public HeadAndTail(SimpleNode head, SimpleNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
