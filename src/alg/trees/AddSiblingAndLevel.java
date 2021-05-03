package alg.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Suppose we have predefined binary tree. Every node has link to left and right children. We'd like to extend every
 * Node by adding 2 additional fields:
 * - siblings -> populate sibling (link between current Node and nearest Node at the same level)
 * - level -> populate level for every Node in the tree
 *
 * The goal is to write a code which starts from root and populate 2 new fields for every node.
 */
public class AddSiblingAndLevel {

    public static void main(String[] args) {
        NodeExt root = new NodeExt(new NodeExt(new NodeExt(), null), new NodeExt(new NodeExt(), new NodeExt()));
        enrichTree2(root);
        System.out.println(root);
    }

    private static void enrichTree(NodeExt root) {
        if (root == null) return;

        Queue<NodeExt> queue = new LinkedList<>();
        Queue<NodeExt> queueChildHolder = new LinkedList<>();
        Queue<NodeExt> queueTemp;

        int level = 0;
        NodeExt nodeCur;
        NodeExt nodeSibling;

        queue.add(root);
        while(!queue.isEmpty()) {
            nodeCur = queue.poll();
            while (nodeCur != null) {
                nodeSibling = queue.poll();

                nodeCur.siblings = nodeSibling;
                nodeCur.level = level;

                if (nodeCur.left != null) queueChildHolder.add(nodeCur.left);
                if (nodeCur.right != null) queueChildHolder.add(nodeCur.right);

                nodeCur = nodeSibling;
            }
            queueTemp = queue;
            queue = queueChildHolder;
            queueChildHolder = queueTemp;

            ++level;
        }
    }

    private static void enrichTree2(NodeExt root) {
        if (root == null) return;

        Queue<NodeExt> queue = new LinkedList<>();

        int level = 0;
        NodeExt nodeCur = null;
        NodeExt nodeSibling = null;

        queue.add(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; ++i) {
                if (nodeCur == null) nodeCur = queue.poll();

                if (i != queueSize - 1) {
                    nodeSibling = queue.poll();
                    nodeCur.siblings = nodeSibling;
                }
                nodeCur.level = level;

                if (nodeCur.left != null) queue.add(nodeCur.left);
                if (nodeCur.right != null) queue.add(nodeCur.right);

                nodeCur = nodeSibling;
            }
            nodeCur = null;
            ++level;
        }
    }

    private static class NodeExt {
        NodeExt left;
        NodeExt right;
        NodeExt siblings; // not initialized
        int level; // not initialized

        public NodeExt() {
        }

        public NodeExt(NodeExt left, NodeExt right) {
            this.left = left;
            this.right = right;
        }
    }
}
