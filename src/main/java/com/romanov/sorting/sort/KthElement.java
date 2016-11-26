package com.romanov.sorting.sort;

import java.util.Random;

public class KthElement {
    public static int kthElement(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            if (left >= right)
                return arr[left];

            int mid = partition(arr, left, right);

            if (mid == k) {
                return arr[mid];
            } else if (mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public static int partition(int[] arr, int left, int right) {
        Random rnd = new Random();
        int index = rnd.nextInt(right - left) + left;
        Helper.swap(arr, left, index);

        int x = arr[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= x) {
                j++;
                Helper.swap(arr, i, j);
            }
        }
        Helper.swap(arr, left, j);

        return j;
    }
}