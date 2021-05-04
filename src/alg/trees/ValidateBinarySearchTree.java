package alg.trees;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3)))); // true
        System.out.println(isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4,
            new TreeNode(3), new TreeNode(6))))); // false
        System.out.println(isValidBST(new TreeNode(Integer.MIN_VALUE, new TreeNode(Integer.MIN_VALUE), null))); // false
        System.out.println(isValidBST(new TreeNode(Integer.MAX_VALUE, new TreeNode(Integer.MAX_VALUE), null))); // false
    }

    private static boolean isValidBST(TreeNode root) {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBst(TreeNode node, int min, int max) {
        if (node == null) return true;

        // compare parent with nearest children (useful for repeated Int.min or Int.max cases)
        boolean isValidNode =
            (node.left == null || node.val > node.left.val) &&
            (node.right == null || node.val < node.right.val);

        boolean isValidValue = node.val >= min && node.val <= max;

        return isValidNode && isValidValue &&
            isBst(node.left, min, node.val == Integer.MIN_VALUE ? Integer.MIN_VALUE : node.val - 1) &&
            isBst(node.right, node.val == Integer.MAX_VALUE ? Integer.MAX_VALUE : node.val + 1, max);
    }
}
