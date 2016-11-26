package com.romanov.sorting.sort;

/**
 * Created by olerom on 19.11.16.
 */
public class InsertionSort {
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j;
            int curr = array[i];
            for (j = i; j > 0 && array[j - 1] > curr; j--) {
                array[j] = array[j - 1];
            }
            array[j] = curr;
        }
        return array;
    }
}
