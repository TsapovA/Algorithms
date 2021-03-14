package alg.linkedList;

/**
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 *
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
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

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists instance = new MergeTwoSortedLists();

        display(instance.mergeTwoLists(init(1, Position.LEFT), init(1, Position.RIGHT)));
        display(instance.mergeTwoLists(init(2, Position.LEFT), init(2, Position.RIGHT)));
        display(instance.mergeTwoLists(init(3, Position.LEFT), init(3, Position.RIGHT)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l1.val > l2.val)) {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            } else {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }
        }
        return head.next;
    }

    private static ListNode init(int exampleNumber, Position position) {
        switch (exampleNumber) {
            case 1:
                switch (position) {
                    case LEFT:
                        return new ListNode(1, new ListNode(2, new ListNode(4)));
                    case RIGHT:
                        return new ListNode(1, new ListNode(3, new ListNode(4)));
            }
            case 2:
                switch (position) {
                    case LEFT:
                    case RIGHT:
                        return null;
                }
            case 3:
                switch (position) {
                    case LEFT:
                        return null;
                    case RIGHT:
                        return new ListNode(0);
                }
            default: throw new IllegalArgumentException();
        }
    }

    private static void display(ListNode node) {
        ListNode temp = node;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class ListNode {
          int val;
          ListNode next;

          ListNode() { }
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      private enum Position {
        LEFT, RIGHT
      }
}
