package alg.linkedList;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 *
 *     k == lists.length
 *     0 <= k <= 104
 *     0 <= lists[i].length <= 500
 *     -104 <= lists[i][j] <= 104
 *     lists[i] is sorted in ascending order.
 *     The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedLists {

    //[1,4,5],[1,3,4],[2,6]
    public static void main(String[] args) {
        ListNode[] listNode = new ListNode[]{
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))};

        System.out.println(mergeKLists(listNode)); // [1,1,2,3,4,4,5,6]
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode[] current = new ListNode[lists.length];
        for (int i = 0; i < lists.length; ++i) {
            current[i] = lists[i];
        }

        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (true) {
            boolean finish = true;
            for (ListNode node: current) {
                if (node != null) {
                    finish = false;
                    break;
                }
            }

            if (finish) {
                return res.next;
            }

            int localMaxIdx = 0;
            for (int i = 1; i < lists.length; ++i) {
                if (current[i] == null) {
                    continue;
                }

                if (current[localMaxIdx] == null) {
                    localMaxIdx = i;
                } else {
                    localMaxIdx = current[localMaxIdx].val < current[i].val ? localMaxIdx : i;
                }
            }
            temp.next = current[localMaxIdx];
            temp = temp.next;

            current[localMaxIdx] = current[localMaxIdx].next;
        }
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
