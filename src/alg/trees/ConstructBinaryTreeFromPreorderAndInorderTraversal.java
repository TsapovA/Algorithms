package alg.trees;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // must be at class level because every traversal should increase the number by one
    private static int preorderRootIdx = 0;

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        buildTree(new int[]{-1}, new int[]{-1});
        buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return preorder.length == 0 ?
            new TreeNode() :
            generateSubtreeNode(0, inorder.length - 1, preorder, inorder);
    }

    private static TreeNode generateSubtreeNode(int inorderLeftIdx, int inorderRightIdx, int[] preorder, int[] inorder) {
        if (inorderLeftIdx > inorderRightIdx) return null;

        int rootValue = preorder[preorderRootIdx++];
        int inorderRootIdx;
        for (inorderRootIdx = inorderLeftIdx; inorderRootIdx <= inorderRightIdx; ++inorderRootIdx) {
            if (rootValue == inorder[inorderRootIdx]) break;
        }
        TreeNode subtreeRoot = new TreeNode(rootValue);
        subtreeRoot.left = generateSubtreeNode(inorderLeftIdx, inorderRootIdx - 1, preorder, inorder);
        subtreeRoot.right = generateSubtreeNode(inorderRootIdx + 1, inorderRightIdx, preorder, inorder);
        return subtreeRoot;
    }
}
