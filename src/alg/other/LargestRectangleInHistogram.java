package alg.other;

import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * <p>
 * Example 1:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * <p>
 * Example 2:
 * Input: heights = [2,4]
 * Output: 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 10^5
 * 0 <= heights[i] <= 10^4
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        // TODO: check the first case
        System.out.println(largestRectangleArea(new int[]{2, 1, 4, 5, 1, 3, 3})); // 8
        System.out.println(largestRectangleArea(new int[]{0, 1, 0, 2, 0, 3, 0})); // 3
        System.out.println(largestRectangleArea(new int[]{4, 2, 0, 3, 2, 5})); // 6
        System.out.println(largestRectangleArea(new int[]{3, 2, 3})); // 6
        System.out.println(largestRectangleArea(new int[]{2, 1, 2})); // 3
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(largestRectangleArea(new int[]{2, 4})); // 4
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = i - 1 - stack.peek();
                res = Math.max(res, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - 1 - stack.peek();
            res = Math.max(res, width * height);
        }
        return res;
    }
}
