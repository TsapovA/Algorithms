package alg.arrays;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either
 * directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
 * (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 *
 *
 * Example 1:
 *
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 * Example 2:
 *
 *
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class MinimumFallingPathSum {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{ // 13
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        }));

        System.out.println(minFallingPathSum(new int[][]{ // -59
                {-19, 57},
                {-40, -5}
        }));
    }

    private static int minFallingPathSum(int[][] matrix) {
        int[][] minValues = new int[matrix.length][matrix.length];
        System.arraycopy(matrix[0], 0, minValues[0], 0, matrix.length);

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                minValues[i][j] = matrix[i][j] + Math.min(Math.min(minValues[i - 1][j], minValues[i - 1][Math.max(0, j - 1)]), minValues[i - 1][Math.min(j + 1, matrix.length - 1)]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; ++ j) {
            min = Math.min(min, minValues[matrix.length - 1][j]);
        }
        return min;
    }
}
