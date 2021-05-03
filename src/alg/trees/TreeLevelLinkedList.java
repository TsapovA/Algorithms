package alg.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 4.3. Для бинарного дерева разработайте алгоритм, который создает связный список всез узлов,
 * находящихся на каждой глубине (для дерева с глубиной D должно получиться D связных списков
 */
public class TreeLevelLinkedList {

    List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        result.add(current);

        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for(TreeNode parent: parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}
