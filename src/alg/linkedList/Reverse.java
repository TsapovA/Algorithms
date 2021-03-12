package alg.linkedList;

/**
 * Change direction of a linkedList
 */
public class Reverse {

    public static void main(String[] args) {
        Node node = init();
        System.out.print("Init: ");
        display(node);

        Node reverse = reverse(node);
        System.out.print("Reversed: ");
        display(reverse);
    }

    private static Node init(){
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Node node3 = new Node(3, 3);
        Node node4 = new Node(4, 4);
        Node node5 = new Node(5, 5);
        Node node6 = new Node(6, 6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        return node1;
    }

    private static Node reverse (Node node){
        Node prev = node;
        Node cur = prev.next;
        Node next = cur.next;
        prev.next = null;

        while(next != null) {
            cur.next = prev;

            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;
        return cur;
    }

    private static void display(Node node) {
        Node temp = node;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class Node {

        public final int key;
        public final int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        private static void displayLinkedList(Node init) {
            Node temp = init;
            while (temp != null) {
                System.out.print(temp.key + " -> ");
                temp = temp.next;
            }
        }
    }
}
