package alg.trees;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
 * is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 *
 * Constraints:
 *
 *     1 <= inorder.length <= 3000
 *     postorder.length == inorder.length
 *     -3000 <= inorder[i], postorder[i] <= 3000
 *     inorder and postorder consist of unique values.
 *     Each value of postorder also appears in inorder.
 *     inorder is guaranteed to be the inorder traversal of the tree.
 *     postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3})); // [3,9,20,null,null,15,7]
        System.out.println(buildTree(new int[]{-1}, new int[]{-1})); // [-1]
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // root of the subtree is the top right value (with idx = postEnd) of postorder array
        int postRoot = postorder[postEnd];
        TreeNode root = new TreeNode(postRoot);

        // find root value in inorder array
        int inRootIdx = -1;
        for (int i = inStart; i <= inEnd; ++i) {
            if (postRoot == inorder[i]) {
                inRootIdx = i;
                break;
            }
        }

        // determine size of left and right subtrees
        int leftSubtreeSize = inRootIdx - inStart;
        int rightSubtreeSize = inEnd - inRootIdx;

        root.left = buildTree(inorder, inStart, inRootIdx - 1, postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTree(inorder, inRootIdx + 1, inEnd, postorder, postEnd - rightSubtreeSize,postEnd - 1);

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}
