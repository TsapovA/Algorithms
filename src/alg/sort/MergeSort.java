package alg.sort;

import java.util.Arrays;

/**
 * time - O(N*log2(N))
 * space - O(n)
 */
public class MergeSort {

    public static void main(String[] args) {
        long[] array = {5, 4, 3, 2, 1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(long[] array) {
        long[] workSpace = new long[array.length];
        recMergeSort(array, workSpace, 0, array.length - 1);
    }

    private static void recMergeSort(long[] array, long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) return;

        int mid = (lowerBound + upperBound) / 2;
        recMergeSort(array, workSpace, lowerBound, mid);
        recMergeSort(array, workSpace, mid + 1, upperBound);
        merge(array, workSpace, lowerBound, mid + 1, upperBound);
    }

    private static void merge(long[] array, long[] workSpace, int lowerBound, int upArrStart, int upperBound) {
        int j = 0;
        int lowIdx = lowerBound;
        int highIdx = upArrStart;

        while (lowIdx < upArrStart && highIdx <= upperBound) {
            if (array[lowIdx] < array[highIdx]) {
                workSpace[j++] = array[lowIdx++];
            } else {
                workSpace[j++] = array[highIdx++];
            }
        }

        while (lowIdx < upArrStart) {
            workSpace[j++] = array[lowIdx++];
        }

        while (highIdx <= upperBound) {
            workSpace[j++] = array[highIdx++];
        }

        for (j = 0; j < upperBound - lowerBound + 1; ++j) {
             array[lowerBound + j] = workSpace[j];
        }
    }
}
