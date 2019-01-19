package alg.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        display(twoSum(new int[]{2, 7, 11, 15}, 18));
    }

    private static void display(int[] ints) {
        System.out.println("i1 = " + ints[0] + " i2 = " + ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            Integer temp = target - nums[i];
            Integer val = map.get(temp);

            if (val == null) {
                map.put(nums[i], i);
            } else {
                arr[0] = i;
                arr[1] = val;
                break;
            }
        }
        return arr;
    }
}
