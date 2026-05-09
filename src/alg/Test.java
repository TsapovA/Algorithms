package alg;

import java.util.*;
import java.lang.*;

class Test {
    public static void main (String[] args) {
        int[] result = searchRange(new int[]{1, 2, 2, 3, 4, 4, 4, 5}, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int leftRes = 0;
        int rightRes = 0;

        int startIdx = 0;
        int endIdx = nums.length - 1;

        while (startIdx < endIdx) {
            int idx = (startIdx + endIdx) / 2;
            if (nums[idx] < target) {
                startIdx = idx;
                System.out.println("main loop startIdx:" + startIdx);
            } else if (nums[idx] > target) {
                endIdx = idx;
                System.out.println("main loop endIdx:" + endIdx);
            } else {
                leftRes = searchLeftEquals(nums, target, startIdx, idx);
                rightRes = searchRightEquals(nums, target, idx, endIdx);
                break;
            }

        }
        return new int[] {leftRes, rightRes};
    }

    private static int searchLeftEquals(int[] nums, int target, int startIdx, int endIdx) {
        int resIdx = endIdx;
        while (startIdx < endIdx) {
            int idx = (startIdx + endIdx) / 2;
            if (nums[idx] < target) {
                startIdx = idx;
                System.out.println("aux loop left startIdx:" + endIdx);
            } else {
                resIdx = idx;
                endIdx = idx;
                System.out.println("aux loop left endIdx:" + endIdx);

            }
            if (startIdx == endIdx - 1) {
                break;
            }
        }
        return resIdx;
    }

    private static int searchRightEquals(int[] nums, int target, int startIdx, int endIdx) {
        int resIdx = startIdx;
        while (startIdx < endIdx) {
            int idx = (startIdx + endIdx) / 2;
            if (nums[idx] > target) {
                endIdx = idx;
                System.out.println("aux loop right endIdx:" + endIdx);
            } else {
                resIdx = idx;
                startIdx = idx;
                System.out.println("aux loop left startIdx:" + endIdx);
            }
            if (startIdx == endIdx - 1) {
                break;
            }
        }
        return resIdx;
    }
}