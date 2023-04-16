package alg.numbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        System.out.println(isUniqueOccurrence(new int[]{1,2,2,1,1,3})); //true
        System.out.println(isUniqueOccurrence(new int[]{1,2})); // false
        System.out.println(isUniqueOccurrence(new int[]{-3,0,1,-3,1,1,1,-3,10,0})); // true

        System.out.println(isUniqueOccurrence2(new int[]{1,2,2,1,1,3})); //true
        System.out.println(isUniqueOccurrence2(new int[]{1,2})); // false
        System.out.println(isUniqueOccurrence2(new int[]{-3,0,1,-3,1,1,1,-3,10,0})); // true

        System.out.println(isUniqueOccurrence2(new int[]{
                -488,114,-186,-204,-510,160,-797,963,-761,96,974,814,278,959,848,-186,278,870,-761,-179,974,-701,870,-60,
                388,870,278,594,-761,114,114,-957,333,-203,333,161,959,-510,-488,-203,870,27,870,-204,333,161,-570,-570,
                -517,-517,-790,-570,-957,814,96,-797,959,379,-701,-179,-204,-203,814,333,278,959,870,-701,594,-510,96,
                974,-4,333,278,-701,278,974,-761,954,-186,-60,-701,161,-958,594,974,161,278,-217,-186,-510,848,-517,408,
                974,278,-761,379,963,-60,963,27,-610,333,814,379,-510,278,-179,-701,-570,161,96,-761,974,-570,379,388,
                -203,27,114,-761,-957,-610,-570,814,-701,-60,96,-510,333,-761,388,160,114,974,-701,814,-701,-4,-179,
                -570,379,160,-217,-801,379,333,-203,-570,814,963,-701,-203,959,-957,-801,-572,-797,-701,333,161,278,-217
                ,-797,-957,-179,814,814,848,814,-701,-801,-610,-957,974,-761,96,870,-701,114,379,974,-60,-570,379,278,
                114,-186,-60,848,963,-761,96,-610,594,-797,278,-701,-203,161,388,-217,96,-60,278,-217,-761,27,-701,-179,
                333,-701,-217,-217,96,379,-958,96,-217,-60,814,963,-958,-60,27,388,-797,-510,-203,-203,-510,974,27,-797,
                325,-761,954,-570,114,-610,814,-510,379,-570,379,-570,-797,-4,814,814,-510,-217,-957,848,-701,316,-801,
                -203,388,-517,96,316,-488,848,-186,-203,96,-958,161,114,388,27,-203,160,161,963,96,-179,388,379,959,-957
                ,333,594,-203,-217,-510,388,-958,-203,594,-204,-957,161,-761,974,-217,388,-610,278,-957,-572,114,316,
                408,278,160,-570,-60,333,-510,-957,-203,-203,-510,-570,-576,114,96,388,-179,-217,-790,160,-576,278,333,
                814,333,-217,959,333,-576,974,-60,-570,388,-701,37,316,870,-217,-958,-179,-610,-797,-217,-761,-957,278,
                959,-570,-204,963,-510,379,870,114,-510,959,814,379,-790,379,160,-797,333,870,-701,-958,-958,-217,-4,
                963,96,333,-203,278,-761,408,408,-217,974,114,-570,-203,161,848,-217,96,96,594,278,160,-203,333,963,
                -510,814,-186,-801,160,96,333,-217,-570,814,-790,-701,-179,-701,278,27,848,814,-203,-204,-60,-517,408,
                379,-186,-761,-517,-570,-510,278,-801,-797,-797,408,594,-958,114,160,-610,959,325,161,388,114,-203,388,
                -217,-572,974,-4,-217,-790,161,-203,870,-186,-186,278,-217,-510,114,-60,96,959,-572,-217,974,-610,278,
                -610,-797,-572,-179,379,388,114,-958,-701,278,27,-204,954,870,-204,408,96,333,-186,-217,-701,-179,594,
                -761,954,-4,814,-488,96,-203,-957,-797,-179,388,959,-701,96,-570,-572,974,-570,-217,-576,333,-761,-510,
                -958,974,-217,-610,974,333,-60,-217,814,-217,-204,814,870,-957,278,96,-957,959,-186,-701,114,870,-957,
                974,-179,-701,379,-60,-179,-570,-957,870,-217,848,160,814,160,-510,-576,-203,963,408,333,848,278,379,
                814,963,-957,333,-761,-701,-186,114,594,-797,-801,-570,-517,278,316,959,954,959,-701,388,848,-801,848,
                96,-4,-576,870,96,-701,161,848,-610,-761,-958,-179,333,-570,-179,-801,-761,-570,114,-517,974,-957,-958,
                -179,814,160,114,-204,96,-957,-797,379,278,-510,-701,-4,-217,278,814,-701,333,96,-510,814,-517,37,-203,
                -217,-203,974,-510,-217,848,-510,974,-204,-957,-570,-801,-701,-510,-797,161,388,-203,161,333,963,114,
                388,388,814,160,27,388,-610,814,814,-203,-570,894,-203,333,594,-701,408,-179,27,27,959,333,-179,-761,
                161,96,-610,278,388,96,814,-203,594,-797,-701,-570,161,-510,379,870,-203,96,-570,-203,333,114,379,-761,
                848,-761,963,96,959,-797,388,848,160,-510,96,-610,96,-204,316,96,388,-186,-958,-510,160,974,814,-179,
                379,-570,-488,-797,-701,-570,-217,594,-217,-957,161,-797,-4,-957,-761,814,-957,333,114,-801,-179,-958,
                -761,-60,-797,316,388,814,-761,388,-204,959,278,114,974,-517,-517,379,-60,388,-217,333,-204,-179,-701,
                848,-761,-510,870,870,870,-217,-217,114,408,-204,-958,114,161,-957,848,-203,594,-797,408,848,-801,161,
                278,-761,388,-957,-701,-570,-572,-958,408,278,-610,96,161,160,-761,-610,959,-217,-186,-510,-179,963,
                -179,333,-510,959,379,814,594,-203,333,848,-217,-204,-797,-186,-570,114,408,974,-179,-60,814,-701,388,
                379,379,388,814,870,870,161,316,594,-761,-570,96,333,954,870,-572,-179,333,37,-517,-204,814,-204,814,
                379,963,-761,-957,-203,959,160,278,-186,-572,848,160,278,-179,-761,848,870,974,814,-510,-203,-204,161,
                -60,114,-179,333,-186,-572,96,333,278,-701,333,-179,-761,848,47,278,-204,160,-957,161,848,814,37,-204,
                -610,388,96,-179,379,959,959,114,974,388,-203,-179,96,-203,-204,114,-797,-761,-957,-517,-488,974,814,
                -570,959,-701,-797,-610,-510,278,-60,-488,114,-4,870,316,27,-610,-958,-488,-761,-4,161,27,-179,870,-610
                ,963,-217,848,379,-179,814,-797,379,-570,-204,870,278,-570,894,-179,-701,-701,160,-510,160,-217,325,814,
                27,408,278,333,-797,974,-217,-186,-576,333,-217,388})); //true
    }

    private static boolean isUniqueOccurrence(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value: arr) {
            map.merge(value, 1, Integer::sum);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }

    // Not working, fix
    private static boolean isUniqueOccurrence2(int[] arr) {
        int[] countArr = new int[2001];
        for (int value: arr) {
            ++countArr[value + 1000];
        }

        for (int i = 0; i < countArr.length; ++i) {
            int counter = countArr[i];
            if (counter == 0 || counter == -1) {
                continue;
            }
            boolean noDuplicates = performStep(countArr, i);
            if (!noDuplicates) {
                return false;
            }
        }
        return true;
    }

    private static boolean performStep(int[] countArr, int idx) {
        if (idx < 0) {
            return false;
        }
        int checkedValue = countArr[idx];
        if (checkedValue == 0) {
            return true;
        }
        if (checkedValue == -1) {
            return false;
        }

        int nextCheckedIdx = countArr[checkedValue];
        countArr[checkedValue] = -1;
        return performStep(countArr, nextCheckedIdx);
    }
}