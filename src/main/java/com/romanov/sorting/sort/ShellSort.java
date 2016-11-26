package com.romanov.sorting.sort;

/**
 * Created by olerom on 19.11.16.
 */
public class ShellSort {
    public static int[] sort(int[] array) {

        int step = array.length >> 1;
        while (step > 0) {
            for (int i = 0; i < (array.length - step); i++) {
                int j = i;

                while (j >= 0 && array[j] > array[j + step]) {
                    Helper.swap(array, j, j + step);
                    j--;
                }
            }
            step >>= 1;
        }

        return array;
    }
}
