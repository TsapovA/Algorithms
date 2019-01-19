package alg.linkedList;

public class Node {

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
