package alg.linkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        displayListNodeChain(removeNthFromEnd(initFirstExample(), 2));
        displayListNodeChain(removeNthFromEnd(initSecondExample(), 1));
        displayListNodeChain(removeNthFromEnd(new ListNode(1), 1));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        // used for edge cases
        ListNode temp = new ListNode(0, head);
        ListNode first = temp;
        ListNode second = temp;
        // create gap of (n + 1) elements between two pointers
        for (int i = 1; i <= n + 1; ++i) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return temp.next;
    }

    private static ListNode initFirstExample() {
        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        return new ListNode(1, second);
    }

    private static ListNode initSecondExample() {
        ListNode second = new ListNode(2);
        return new ListNode(1, second);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static void displayListNodeChain(ListNode init) {
        ListNode temp = init;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
