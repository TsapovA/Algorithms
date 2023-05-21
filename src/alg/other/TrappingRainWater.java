package alg.other;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it can trap after raining.
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trap2(height));

        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }

    // brute force. Time - O(N^2), space - O(1)
    private static int trap(int[] height) {
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            leftMax = 0;
            rightMax = 0;
            for (int j = i; j >= 0; --j) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; ++j) {
                rightMax = Math.max(rightMax, height[j]);
            }
            result += Math.min(leftMax, rightMax) - height[i];
        }
        return result;
    }

    // 2 pointers. Time - O(N), space - O(1)
    private static int trap2(int[] height) {
        int leftIdx = 0;
        int leftMax = 0;
        int rightIdx = height.length - 1;
        int rightMax = 0;
        int result = 0;
        while (leftIdx < rightIdx) {
            if (leftMax < rightMax) {
                if (height[leftIdx] > leftMax) {
                    leftMax = height[leftIdx];
                } else {
                    result += leftMax - height[leftIdx];
                    ++leftIdx;
                }
            } else {
                if (rightMax < height[rightIdx]) {
                    rightMax = height[rightIdx];
                } else {
                    result += rightMax - height[rightIdx];
                    --rightIdx;
                }
            }
        }
        return result;
    }
}
