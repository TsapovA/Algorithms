package alg.arrays;

import alg.linkedList.ListNode;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
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
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
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
public class MergeKSortedLists {

    public static void main(String[] args) {
        // [[-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]]
        mergeKListsDivideAndConquer(new ListNode[]{
            new ListNode(-10, new ListNode(-9, new ListNode(-9, new ListNode(-3, new ListNode(-1, new ListNode(-1, new ListNode(0))))))),
            new ListNode(-5),
            new ListNode(4),
            new ListNode(-8),
            null,
            new ListNode(-9, new ListNode(-6, new ListNode(-5, new ListNode(-4, new ListNode(-2, new ListNode(2, new ListNode(3))))))),
            new ListNode(-3, new ListNode(-3, new ListNode(-2, new ListNode(-1, new ListNode(0)))))
            }); // [-10,-9,-9,-9,-8,-6,-5,-5,-4,-3,-3,-3,-2,-2,-1,-1,-1,0,0,2,3,4]
        mergeKListsDivideAndConquer(new ListNode[]{new ListNode(), new ListNode()});
        mergeKListsDivideAndConquer(new ListNode[]{
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        });
        mergeKListsDivideAndConquer(new ListNode[]{});
        mergeKListsDivideAndConquer(new ListNode[]{new ListNode()});
    }

    // time - O(kN)
    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHead = null;
        ListNode resultCurrent = null;
        ListNode temp = null;
        int idx = -1;

        while (true) {
            temp = null;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null && (temp == null || temp.val > lists[i].val)) {
                    temp = lists[i];
                    idx = i;
                }
            }
            if (temp == null) break;

            if (resultHead == null) {
                resultHead = temp;
                resultCurrent = temp;
            } else {
                resultCurrent.next = temp;
                resultCurrent = resultCurrent.next;
            }
            lists[idx] = lists[idx].next;
        }
        return resultHead;
    }

    // Divide and Conquer
    // time - O(N*log(k))
    private static ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int adder = 1;
        while (adder < lists.length) {
            for (int i = 0; i + adder < lists.length; i = i + (adder << 1)) {
                lists[i] = mergeTwoListNodes(lists[i], lists[i + adder]);
            }
            adder <<= 1;
        }
        return lists[0];
    }

    private static ListNode mergeTwoListNodes(ListNode first, ListNode second) {
        ListNode res = new ListNode();
        ListNode temp = res;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        if (first != null) {
            temp.next = first;
        } else if (second != null) {
            temp.next = second;
        }
        return res.next;
    }
}
