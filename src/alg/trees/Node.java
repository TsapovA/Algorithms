package alg.trees;

public class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public Node(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayNode() {
        System.out.println("{" + iData + ". " + dData + "}");
    }
}
