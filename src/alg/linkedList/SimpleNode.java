package alg.linkedList;

public class SimpleNode {

    public int val;
    public SimpleNode next;

    public SimpleNode(int val) {
        this.val = val;
    }

    static void displayChains(SimpleNode init) {
        SimpleNode temp = init;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
