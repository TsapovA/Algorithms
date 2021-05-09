package alg.trees;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(maxDepth(new TreeNode(1, null, new TreeNode(2))));
        System.out.println(maxDepth(null));
        System.out.println(maxDepth(new TreeNode(0)));
    }

    private static int maxDepth(TreeNode root) {
        return compareTwoPaths(root, 0);
    }

    private static int compareTwoPaths(TreeNode node, int prevLevel) {
        if (node == null) return prevLevel;
        return Math.max(compareTwoPaths(node.left, prevLevel + 1), compareTwoPaths(node.right, prevLevel + 1));
    }
}
