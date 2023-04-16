package alg.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search/
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * <p>
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * <p>
 * <p>
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED")); // true

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "SEE")); // true

        board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCB")); // false
    }

    private static boolean exist(char[][] board, String word) {
        char[] wordLetters = word.toCharArray();

        Set<IntPair> visited = new HashSet<>(word.length());
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == wordLetters[0]) {
                    IntPair checkedIntPair = new IntPair(i, j);
                    visited.add(checkedIntPair);
                    boolean success = step(wordLetters, board, 1, visited, checkedIntPair);
                    if (success) {
                        return true;
                    }
                    visited.remove(checkedIntPair);
                }
            }
        }
        return false;
    }

    private static boolean step(char[] word, char[][] board, int idx, Set<IntPair> visited, IntPair prev) {
        if (idx == word.length) {
            return true;
        }

        int prevA = prev.getA();
        int prevB = prev.getB();

        for (int i = -1; i <= 1; i += 2) {
            IntPair checkedIntPair = new IntPair(prevA + i, prevB);
            if (prevA + i >= 0
                    && prevA + i < board.length
                    && board[prevA + i][prevB] == word[idx]
                    && !visited.contains(checkedIntPair)) {
                visited.add(checkedIntPair);
                boolean success = step(word, board, idx + 1, visited, checkedIntPair);
                if (success) {
                    return true;
                }
                visited.remove(checkedIntPair);
            }

            checkedIntPair = new IntPair(prevA, prevB + i);
            if (prevB + i >= 0
                    && prevB + i < board[0].length
                    && board[prevA][prevB + i] == word[idx]
                    && !visited.contains(checkedIntPair)) {
                visited.add(checkedIntPair);
                boolean success = step(word, board, idx + 1, visited, checkedIntPair);
                if (success) {
                    return true;
                }
                visited.remove(checkedIntPair);
            }
        }
        return false;
    }

    private static class IntPair {
        private final int a;
        private final int b;

        public IntPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntPair intPair = (IntPair) o;
            return a == intPair.a && b == intPair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
