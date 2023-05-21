package alg.trees;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
 *
 * You are given the root of a binary tree.
 *
 * A ZigZag path for a binary tree is defined as follow:
 *
 *     Choose any node in the binary tree and a direction (right or left).
 *     If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 *     Change the direction from right to left or from left to right.
 *     Repeat the second and third steps until you can't move in the tree.
 *
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 *
 * Return the longest ZigZag path contained in that tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null, 1,null,1]
 * Output: 3
 * Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 *
 * Example 2:
 *
 * Input: root = [1,1,1,null,1,null,null,1,1,null,1]
 * Output: 4
 * Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 5 * 10^4].
 *     1 <= Node.val <= 100
 */
public class LongestZigZagPathInABinaryTree {

    public static void main(String[] args) {
        System.out.println(longestZigZag(
            new TreeNode(1, null,
                new TreeNode(1, new TreeNode(1), new TreeNode(1,
                        new TreeNode(1, null,
                            new TreeNode(1, null,
                                new TreeNode(1))), new TreeNode(1)))))); // 3
    }

    private static int longestZigZag(TreeNode root) {
        Stack<ExtendedNode> stack = new Stack<>();
        stack.push(new ExtendedNode(root, 0, null));
        int max = 0;

        while (!stack.isEmpty()) {
            ExtendedNode pop = stack.pop();
            TreeNode treeNode = pop.node;
            if (treeNode != null) {
                int depthLevel = pop.depthLevel;
                max = Math.max(max, depthLevel);
                Boolean prevNodeLeft = pop.prevNodeLeft;

                stack.push(new ExtendedNode(treeNode.left, prevNodeLeft == null ? 1 : !prevNodeLeft ? depthLevel + 1 : 1, true));
                stack.push(new ExtendedNode(treeNode.right, prevNodeLeft == null ? 1 : prevNodeLeft ? depthLevel + 1 : 1, false));
            }
        }
        return max;
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() { }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class ExtendedNode {

        public final TreeNode node;
        public final int depthLevel;
        public final Boolean prevNodeLeft;

        public ExtendedNode(TreeNode node, int depthLevel, Boolean prevNodeLeft) {
            this.node = node;
            this.depthLevel = depthLevel;
            this.prevNodeLeft = prevNodeLeft;
        }
    }
}
