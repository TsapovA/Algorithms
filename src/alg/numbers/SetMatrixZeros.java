package alg.numbers;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 *
 * You must do it in place.
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 *  Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean isFirstCol = false;
        boolean isFirstRow = false;
        // use first row and col as a marker whether the row/col contains 0;
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) isFirstRow = true;
                    if (j == 0) isFirstCol = true;
                }
            }
        }

        for (int i = 1; i < rowNum; ++i) {
            if (matrix[i][0] == 0) {
                for (int col = 0; col < colNum; ++ col) {
                    matrix[i][col] = 0;
                }
            }
        }

        for (int j = 1; j < colNum; ++j) {
            if (matrix[0][j] == 0) {
                for (int row = 0; row < rowNum; ++row) {
                    matrix[row][j] = 0;
                }
            }
        }

        // firt row and col checks separately using flags
        if (isFirstCol) {
            for (int i = 0; i < rowNum; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (isFirstRow) {
            for (int j = 0; j < colNum; ++j) {
                matrix[0][j] = 0;
            }
        }
    }
}
