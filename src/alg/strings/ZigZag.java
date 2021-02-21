package alg.strings;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */

public class ZigZag {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int rowNum = Math.min(s.length(), numRows);
        StringBuilder[] rows = new StringBuilder[rowNum];
        for (int i = 0; i < rowNum; ++i) {
            rows[i] = new StringBuilder();
        }

        boolean isDown = true;
        int curRow = 0;

        for (char ch: s.toCharArray()) {
            rows[curRow].append(ch);
            curRow += isDown ? 1 : -1;
            if (curRow == 0 || curRow == rowNum - 1) {
                isDown = !isDown;
            }
        }
        StringBuilder result = new StringBuilder();

        for (StringBuilder row: rows) {
            result.append(row);
        }

        return result.toString();
    }
}
