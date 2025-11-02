package alg.trees;

import java.util.*;

import static alg.trees.TreeNode.buildFirstTree;

/**
 * order: root, left subtree, right subtree
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; ++i) {
            System.out.println(i);
            System.out.println(performNodeTraversalStack(buildFirstTree(i)));
        }
    }

    private static List<Integer> performNodeTraversalStack(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            res.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return res;
    }
}
