package com.romanov.sorting.sort;

/**
 * Created by olerom on 19.11.16.
 */
public class InsertionSortBinarySearch {

    public static int[] sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;

            int k = Helper.binarySearch(array, array[i], j);

            int tmp = array[i];
            for (int m = j; m > k - 1; m--) {
                array[m + 1] = array[m];
            }
            array[k] = tmp;
        }

        return array;
    }
}
