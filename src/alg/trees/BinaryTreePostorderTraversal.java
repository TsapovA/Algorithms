package alg.trees;

import java.util.*;

import static alg.trees.TreeNode.buildFirstTree;

/**
 * order: left subtree, right subtree, root.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        for (int i = 1; i <= 6; ++i) {
            System.out.println(i);
            System.out.println(performNodeTraversalStack(buildFirstTree(i)));
        }
    }

    private static List<Integer> performNodeTraversalStack(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }
}
