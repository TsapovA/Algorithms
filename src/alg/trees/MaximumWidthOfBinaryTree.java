package alg.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that
 * level are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 *
 * Example 2:
 *
 * Input: root = [1,3,2,5,null,null,9,6,null,7]
 * Output: 7
 * Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
 *
 * Example 3:
 *
 * Input: root = [1,3,2,5]
 * Output: 2
 * Explanation: The maximum width exists in the second level with length 2 (3,2).
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 3000].
 *     -100 <= Node.val <= 100
 */
public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(widthOfBinaryTree(
            new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9))))); // 4

        System.out.println(widthOfBinaryTree(new TreeNode(1,
            new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
            new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null))))); // 7

        System.out.println(widthOfBinaryTree(new TreeNode(1,
            new TreeNode(3, new TreeNode(5), null),
            new TreeNode(2)))); // 2
    }

    private static int widthOfBinaryTree(TreeNode root) {
        Queue<LeveledTreeNode> queue = new LinkedList<>();
        queue.add(new LeveledTreeNode(root, 0));

        int currentLevelMin = 0;
        int currentLevelMax = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                LeveledTreeNode poll = queue.poll();
                TreeNode node = poll.node;
                int pos = poll.pos;
                if (i == 0) {
                    currentLevelMin = pos;
                }
                if (i == size - 1) {
                    currentLevelMax = pos;
                }
                if (node.left != null) {
                    queue.add(new LeveledTreeNode(node.left, pos * 2));
                }
                if (node.right != null) {
                    queue.add(new LeveledTreeNode(node.right, pos * 2 + 1));
                }
            }
            res = Math.max(res, currentLevelMax - currentLevelMin + 1);
        }
        return res;
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

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

    private static class LeveledTreeNode {
        private final TreeNode node;
        private final int pos;

        public LeveledTreeNode(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
}
