package com.romanov.sorting.sort;

/**
 * Created by olerom on 20.11.16.
 */

public class MergeSortNoMemory {
    public static int[] sort(int[] ar) {
        if (ar == null || ar.length == 0) {
            return new int[]{};
        }
        sort(ar, 0, ar.length - 1);
        return ar;
    }

    private static int[] sort(int[] ar, int left, int right) {
        if (ar == null) {
            return new int[]{};
        }
        if (right - left == 1) {
            if (ar[left] > ar[right])
                Helper.swap(ar, left, right);
        } else if (right - left != 0) {

            int dx = ((int) Math.floor((left + right) / 2));

            sort(ar, left, dx);
            sort(ar, dx + 1, right);
            merge(ar, left, right, dx);
        }
        return ar;
    }

    private static void merge(int[] ar, int left, int right, int mid) {
        int i = left;
        while (i <= mid) {
            if (ar[i] > ar[mid + 1]) {
                Helper.swap(ar, i, mid + 1);
                push(ar, mid + 1, right);
            }
            i++;
        }
    }

    static void push(int[] arr, int left, int right) {
        for (int i = left; i < right; i++) {
            if (arr[i] > arr[i + 1])
                Helper.swap(arr, i, i + 1);
        }
    }
}