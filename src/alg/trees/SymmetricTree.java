package alg.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class SymmetricTree {

    public static void main(String[] args) {
        System.out.println(isPairIter(
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(3), new TreeNode(4)),
                new TreeNode(2,
                    new TreeNode(4), new TreeNode(3)))));

        System.out.println(isPairIter(
            new TreeNode(1,
                new TreeNode(2,
                    null, new TreeNode(3)),
                new TreeNode(2,
                    null, new TreeNode(3)))));
    }

    // Recursion

    private static boolean isSymmetricRecursion(TreeNode root) {
        return root == null || isPairSymmetric(root.left, root.right);
    }

    private static boolean isPairSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.val == right.val && isPairSymmetric(left.left, right.right) && isPairSymmetric(left.right, right.left);
    }

    // Iteration (slower and uses more memory. Checked both variants at LeetCode)

    private static boolean isPairIter(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            // one node is null
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            queue.add(node1.left);
            queue.add(node2.right);

            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
