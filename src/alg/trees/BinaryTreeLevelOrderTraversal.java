package alg.trees;

import java.util.*;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        System.out.println(levelOrderRecursive(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(levelOrderRecursive(new TreeNode(1)));
        System.out.println(levelOrderRecursive(null));
    }

    private static List<List<Integer>> levelOrderIterate(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>(size);
            for (int i = 0; i < size; ++i) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(levelList);
        }
        return result;
    }

    private static List<List<Integer>> levelOrderRecursive(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        return performRecursive(queue, new ArrayList<List<Integer>>());
    }

    private static List<List<Integer>> performRecursive(Queue<TreeNode> levelNodes, List<List<Integer>> result) {
        if (levelNodes.isEmpty()) return result;

        Queue<TreeNode> nextLevelNodes = new LinkedList<>();
        List<Integer> levelInts = new ArrayList<>();
        for (TreeNode node: levelNodes) {
            levelInts.add(node.val);
            if (node.left != null) nextLevelNodes.add(node.left);
            if (node.right != null) nextLevelNodes.add(node.right);
        }
        result.add(levelInts);
        return performRecursive(nextLevelNodes, result);
    }
}
