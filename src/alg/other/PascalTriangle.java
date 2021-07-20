package alg.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *  Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 *  Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= numRows <= 30
 */
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println(generate(1)); // [[1]]
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; ++i) {
            Integer[] innerList = new Integer[i + 1];
            innerList[0] = 1;
            innerList[i] = 1;
            if (i > 1) {
                for (int j = 1; j < innerList.length - 1; ++j) {
                    List<Integer> prevRow = res.get(i - 1);
                    innerList[j] = prevRow.get(j - 1) + prevRow.get(j);
                }
            }
            res.add(Arrays.asList(innerList));
        }
        return res;
    }
}
