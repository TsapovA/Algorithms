package alg.sort;


import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr1 = {5, 3, 4, 1, 2};
        insertSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {9};
        insertSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[0];
        insertSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    private static void insertSort(int[] arr) {
        for (int out = 1; out < arr.length; ++out) {
            int temp = arr[out];
            int in = out - 1;
            for (; in >= 0; --in) {
                if (temp < arr[in]) {
                    arr[in + 1] = arr[in];
                } else {
                    break;
                }
            }
            arr[in + 1] = temp;
        }
    }
}
