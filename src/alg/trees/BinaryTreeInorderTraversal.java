package alg.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [2,1]
 *
 *  Example 5:
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; ++i) {
            System.out.println(inorderTraversal(buildFirstTree(i)));
        }
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        performNodeTraversal(root, result);
        return result;
    }

    private static void performNodeTraversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        performNodeTraversal(node.left, result);
        result.add(node.val);
        performNodeTraversal(node.right, result);
    }

    private static TreeNode buildFirstTree(int num) {
        switch(num) {
            case 1:  return new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
            case 2: return null;
            case 3: return new TreeNode(1);
            case 4: return new TreeNode(1, new TreeNode(2), null);
            case 5: return new TreeNode(1, null, new TreeNode(2));
            default: throw new UnsupportedOperationException();
        }
    }
}
