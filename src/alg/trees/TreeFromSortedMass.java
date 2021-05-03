package alg.trees;

/**
 * 4.2. Напишите алгоритм создания бинарного дерева поиска с минимальной высотой для отсортированного (по возрастанию)
 * массива с уникальными целочисленными элементами
 */
public class TreeFromSortedMass {
    TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(mid);
        n.left = createMinimalBST(arr, 0, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}
