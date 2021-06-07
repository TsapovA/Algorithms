package alg.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        // example 3
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();
        int rightBorder = matrix[0].length;
        int bottomBorder = matrix.length;
        int leftBorder = -1;
        int topBorder = -1;
        List<Integer> result = new ArrayList<>();
        while (!isFinished(leftBorder, rightBorder, bottomBorder, topBorder)) {
            for (int j = leftBorder + 1; j < rightBorder; ++j) {
                result.add(matrix[topBorder + 1][j]);
            }
            ++topBorder;

            for (int i = topBorder + 1; i < bottomBorder; ++i) {
                result.add(matrix[i][rightBorder - 1]);
            }
            --rightBorder;
            // it's compulsory to check at that point, see example 3
            if (isFinished(leftBorder, rightBorder, bottomBorder, topBorder)) return result;

            for (int j = rightBorder - 1; j > leftBorder; --j) {
                result.add(matrix[bottomBorder - 1][j]);
            }
            --bottomBorder;

            for (int i = bottomBorder - 1; i > topBorder; --i) {
                result.add(matrix[i][leftBorder + 1]);
            }
            ++leftBorder;
        }
        return result;
    }

    private static boolean isFinished(int leftBorder, int rightBorder, int bottomBorder, int topBorder) {
        return (leftBorder >= rightBorder - 1) || (topBorder >= bottomBorder - 1);
    }
}
