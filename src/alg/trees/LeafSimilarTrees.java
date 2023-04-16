package alg.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 * <p>
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        performStep(root1, list);
        int[] pos = new int[1];
        boolean res = performStep(root2, list, pos);
        if (!res) {
            return false;
        }
        return pos[0] == list.size();
    }

    private void performStep(TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        if (node.left != null) {
            performStep(node.left, list);
        }
        if (node.right != null) {
            performStep(node.right, list);
        }
    }

    private boolean performStep(TreeNode node, List<Integer> list, int[] pos) {
        if (node.left == null && node.right == null) {
            return pos[0] < list.size()&& list.get(pos[0]++).equals(node.val);
        }
        if (node.left != null) {
            boolean res = performStep(node.left, list, pos);
            if (!res) {
                return false;
            }
        }
        if (node.right != null) {
            return performStep(node.right, list, pos);
        }
        return true;
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
