package alg.arrays;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 *
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every
 * non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 *
 * Input: grid = [[0,1],[2,0]]
 * Output: 0
 * Explanation: There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 20
 * 1 <= m * n <= 20
 * -1 <= grid[i][j] <= 2
 * There is exactly one starting cell and one ending cell.
 */
public class UniquePathsIII {

    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}})); // 2
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}})); // 4
        System.out.println(uniquePathsIII(new int[][]{{0,1},{2,0}})); // 0
    }

    private static int uniquePathsIII(int[][] grid) {
        int startRow = 0;
        int startCol = 0;
        int availableCells = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                    ++availableCells;
                }
                if (grid[i][j] == 0) ++availableCells;
            }
        }
        int[] foundPaths = new int[1];
        dfs(grid, startRow - 1, startCol, 1, foundPaths, availableCells);
        dfs(grid, startRow + 1, startCol, 1, foundPaths, availableCells);
        dfs(grid, startRow, startCol - 1, 1, foundPaths, availableCells);
        dfs(grid, startRow, startCol + 1, 1, foundPaths, availableCells);
        return foundPaths[0];
    }

    private static void dfs(int[][] grid, int row, int col, int steps, int[] foundPaths, int availableCells) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == -1 || grid[row][col] == -2 || grid[row][col] == 1) {
            return;
        }
        if (grid[row][col] == 2) {
            if (steps == availableCells) {
                ++foundPaths[0];
            }
            return;
        }
        grid[row][col] = -2; // visited
        dfs(grid, row - 1, col, steps + 1, foundPaths, availableCells);
        dfs(grid, row + 1, col, steps + 1, foundPaths, availableCells);
        dfs(grid, row, col - 1, steps + 1, foundPaths, availableCells);
        dfs(grid, row, col + 1, steps + 1, foundPaths, availableCells);
        grid[row][col] = 0;
    }
}
