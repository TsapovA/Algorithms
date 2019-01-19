package alg.binaryTree;

public class binaryTree implements Tree {

    private Node root;

    @Override
    public Node find(int key) {
        if (root == null) {
            return null;
        }

        Node current = root;

        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    @Override
    public void insert(int id, double dd) {
        Node newNode = new Node(id, dd);
        if (root == null) {
            root = newNode;
        } else {
            Node parent = root;
            Node current = root;
            boolean isLeftChild = false;

            while (current != null) {
                parent = current;

                if (current.iData < id) {
                    current = current.leftChild;
                    isLeftChild = true;
                } else {
                    current = current.rightChild;
                    isLeftChild = false;
                }
            }

            if (isLeftChild) {
                parent.leftChild = newNode;
            } else {
                parent.rightChild = newNode;
            }
        }
    }

    @Override
    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = true;

        while (current.iData != id) {
            parent = current;

            if (current.iData < id) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }

            // If we haven't found needed Node
            if (current == null) {
                return false;
            }
        }

        // If deleted Node doesn't have successors
        if (current.leftChild == null && current.rightChild == null) {

            if (current == root) {
                root = null;
                return true;
            }

            if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
        }

        // if deleted Node has only one successor
        else if (current.leftChild == null || current.rightChild == null) {

            if (current.leftChild == null) {
                if (current == root) {
                    root = current.rightChild;
                    return true;
                } else if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {
                    parent.rightChild = current.rightChild;
                }
            } else {
                if (current == root) {
                    root = current.leftChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
            }

            return true;
        }

        // Deleted Node has two successors
        else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            return true;
        }
    }

    private Node getSuccessor(Node node) {
        Node parent = node;
        Node successor = node;
        Node current = node.rightChild;
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != node.rightChild) {
            parent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }
}
