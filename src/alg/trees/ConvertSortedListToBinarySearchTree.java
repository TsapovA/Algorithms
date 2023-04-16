package alg.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * <p>
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced
 * binary search tree.
 *
 * Example 1:
 *
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 *
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * <p>
 * The number of nodes in head is in the range [0, 2 * 104].
 * -105 <= Node.val <= 105
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        System.out.println(sortedListToBST(head));
        System.out.println(sortedListToBSTArray(head));

        head = null;
        System.out.println(sortedListToBST(null));
        System.out.println(sortedListToBSTArray(null));
    }

    // Solution 1: LinkedList

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return performLinkedList(head, null);
    }

    private static TreeNode performLinkedList(ListNode head, ListNode end) {
        if (head == null || head == end) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = performLinkedList(head, slow);
        treeNode.right = performLinkedList(slow.next, end);
        return treeNode;
    }

    // Solution 2: Array

    private static TreeNode sortedListToBSTArray(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        List<Integer> list = new LinkedList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i);
        }

        return performArray(arr, 0, arr.length - 1);
    }

    private static TreeNode performArray(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) {
            return null;
        }

        int midIdx = (leftIdx + rightIdx + 1) / 2;
        TreeNode treeNode = new TreeNode(arr[midIdx]);
        treeNode.left = performArray(arr, leftIdx, midIdx - 1);
        treeNode.right = performArray(arr, midIdx + 1, rightIdx);

        return treeNode;
    }

    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}
