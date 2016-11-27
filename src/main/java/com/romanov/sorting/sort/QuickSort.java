package com.romanov.sorting.sort;

/**
 * Created by olerom on 20.11.16.
 */
public class QuickSort {
    public static int partition(int[] array, int left, int right) {
        int p = array[left + (right - left + 1) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (array[i] < p) i++;
            while (array[j] > p) j--;
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        return j;
    }

    public static int[] sort(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }

        int idx = partition(array, left, right);

        array = sort(array, left, idx);
        array = sort(array, idx + 1, right);
        return array;
    }

    public static int[] sort(int[] arr) {
        if (arr.length > 0) {
            sort(arr, 0, arr.length - 1);
        }
        return arr;
    }
}
