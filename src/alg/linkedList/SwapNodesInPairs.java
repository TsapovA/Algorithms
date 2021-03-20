package alg.linkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]

 * Example 2:
 *
 * Input: head = []
 * Output: []

 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 *
 * Follow up: Can you solve the problem without modifying the values in the list's nodes? (i.e., Only nodes themselves may be changed.)
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        swapPairs(new ListNode());
        swapPairs(new ListNode(1));
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        ListNode node = new ListNode(0, head);;

        while (node.next != null && node.next.next != null) {
            node = swapTwoNodes(node);
        }
        return newHead;
    }

    private static ListNode swapTwoNodes(ListNode prev) {
        ListNode first = prev.next;
        ListNode second = first.next;

        prev.next = second;
        first.next = second.next;
        second.next = first;

        return first;
    }
}
