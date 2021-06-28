package alg.other;

import java.util.*;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 *  Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 *  Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 *  Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {

    private static boolean neededLetterNotExist = false;

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B'}, {'C', 'D'}}, "ACDB")); // true
        System.out.println(exist(new char[][]{{'A'}}, "AB")); // false
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED")); // true
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE")); // true
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB")); // false
    }

    private static boolean exist(char[][] board, String word) {
        neededLetterNotExist = false;
        char[] wordCh = word.toCharArray();
        Map<Character, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                for (char ch : wordCh) {
                    if (board[row][col] == ch) {
                        List<Pair<Integer, Integer>> list = map.getOrDefault(board[row][col], new ArrayList<>());
                        list.add(new Pair<>(row, col));
                        map.put(board[row][col], list);
                        break;
                    }
                }
            }
        }
        return backtrack(wordCh, new ArrayList<>(wordCh.length), map);
    }

    private static boolean backtrack(char[] word, List<Pair<Integer, Integer>> res, Map<Character, List<Pair<Integer, Integer>>> board) {
        if (neededLetterNotExist) return false;
        if (res.size() == word.length) return true;

        Character currentChar = word[res.size()];
        List<Pair<Integer, Integer>> rowColPairs = board.get(currentChar);
        if (rowColPairs == null) {
            neededLetterNotExist = true;
            return false;
        }
        Pair<Integer, Integer> prevPair = res.size() > 0 ? res.get(res.size() - 1) : null;

        for (Pair<Integer, Integer> rowColPair : rowColPairs) {
            Integer row = rowColPair.getA();
            Integer col = rowColPair.getB();
            boolean isSuccess = false;
            boolean isAdded = false;
            for (int i = res.size(); i < word.length; ++i) {
                if ((prevPair == null) ||
                        ((row.equals(prevPair.getA()) && (col.equals(prevPair.getB() + 1) || (col.equals(prevPair.getB() - 1)))) ||
                        (col.equals(prevPair.getB()) && (row.equals(prevPair.getA() + 1) || (row.equals(prevPair.getA() - 1)))))) {
                    Pair<Integer, Integer> pair = new Pair<>(row, col);
                    // exclude duplicates
                    if (res.contains(pair)) continue;
                    isAdded = true;
                    res.add(pair);
                    isSuccess = backtrack(word, res, board);
                }

                if (isSuccess) return true;
            }
            if (isAdded) res.remove(res.size() - 1);
        }
        return false;
    }

    private static class Pair<A, B> {

        private A a;
        private B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(a, pair.a) && Objects.equals(b, pair.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
