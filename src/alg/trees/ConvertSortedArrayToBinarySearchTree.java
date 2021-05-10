package alg.trees;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        sortedArrayToBST(new int[]{1, 3});
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ?
            null :
            generateNode(nums, 0, nums.length - 1);
    }

    private static TreeNode generateNode(int[] nums, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) return null;
        // to avoid int overflow and check both values are odd
        int adder = leftIdx % 2 == 1 && rightIdx % 2 == 1 ? 1 : 0;
        int idx =  leftIdx / 2 + rightIdx / 2 + adder;
        TreeNode node = new TreeNode(nums[idx]);
        node.left = generateNode(nums, leftIdx, idx - 1);
        node.right = generateNode(nums, idx + 1, rightIdx);
        return node;
    }
}
