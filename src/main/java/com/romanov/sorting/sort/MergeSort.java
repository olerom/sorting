package com.romanov.sorting.sort;

/**
 * Created by olerom on 20.11.16.
 */
public class MergeSort {
    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] t = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            t[i - left] = array[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                array[k] = t[j++ - left];
            } else if (j > right) {
                array[k] = t[i++ - left];
            } else if (t[j - left] < t[i - left]) {
                array[k] = t[j++ - left];
            } else {
                array[k] = t[i++ - left];
            }
        }
    }

    public static void sort(int[] a, int left, int right) {
        if (left < right) {
            int mid = ((left + right) >> 1);
            sort(a, left, mid);
            sort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }
}
