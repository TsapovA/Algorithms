package alg.trees;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 2000].
 *     -100 <= Node.val <= 100
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {

    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<TreeNode> nextQueue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        nodeQueue.add(root);
        int i = 0;
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> row = new ArrayList<>(size);
            if (i % 2 == 0) {
                for (int num = 0; num < size; ++num) {
                    TreeNode first = nodeQueue.poll();
                    row.add(first.val);
                    TreeNode left = first.left;
                    if (left != null) {
                        nodeQueue.add(left);
                    }
                    TreeNode right = first.right;
                    if (right != null) {
                        nodeQueue.add(right);
                    }
                }
            } else {
                for (int num = 0; num < size; ++num) {
                    TreeNode last = nodeQueue.pollLast();
                    row.add(last.val);
                    TreeNode right = last.right;
                    if (right != null) {
                        nodeQueue.addFirst(right);
                    }
                    TreeNode left = last.left;
                    if (left != null) {
                        nodeQueue.addFirst(left);
                    }
                }
            }
            if (row.size() > 0) {
                res.add(row);
            }
            ++i;
        }
        return res;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
