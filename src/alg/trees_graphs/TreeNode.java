package alg.trees_graphs;

public class TreeNode {
    public String key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = String.valueOf(key);
    }

    public TreeNode(String key) {
        this.key = key;
    }
}
