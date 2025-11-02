package alg.trees;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static TreeNode buildFirstTree(int num) {
        switch(num) {
            case 1:  return new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
            case 2: return null;
            case 3: return new TreeNode(1);
            case 4: return new TreeNode(1, new TreeNode(2), null);
            case 5: return new TreeNode(1, null, new TreeNode(2));
            case 6: return new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6)));
            default: throw new UnsupportedOperationException();
        }
    }
}
