package alg.trees;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *  Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 *  Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 *  Example 3:
 * Input: root = []
 * Output: []
 *
 *
 *  Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(zigzagLevelOrder(root));

        root = new TreeNode(1);
        System.out.println(zigzagLevelOrder(root));

        root = null;
        System.out.println(zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Deque<TreeNode> deq = new LinkedList<>();
        deq.addFirst(root);
        int level = 1;

        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(root.val));

        while (!deq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int deqSize = deq.size();

            if (level % 2 == 0) {
                for (int i = 0; i < deqSize; ++i) {
                    TreeNode node = deq.pollFirst();
                    if (node.left != null) {
                        deq.addLast(node.left);
                        list.add(node.left.val);
                    }
                    if (node.right != null) {
                        deq.addLast(node.right);
                        list.add(node.right.val);
                    }
                }
            } else {
                for (int i = 0; i < deqSize; ++i) {
                    TreeNode node = deq.pollLast();
                    if (node.right != null) {
                        deq.addFirst(node.right);
                        list.add(node.right.val);
                    }
                    if (node.left != null) {
                        deq.addFirst(node.left);
                        list.add(node.left.val);
                    }
                }
            }
            ++level;
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        return res;
    }
}
