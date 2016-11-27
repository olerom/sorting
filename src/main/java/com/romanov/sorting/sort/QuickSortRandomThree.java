package com.romanov.sorting.sort;

import java.util.Random;

/**
 * Created by olerom on 20.11.16.
 */
public class QuickSortRandomThree {

    public static int[] sort(int[] arr) {
        if (arr.length > 0) {
            qsort(arr, 0, arr.length - 1);
        }
        return arr;
    }

    public static int[] qsort(int[] arr, int t1, int t2) {
        int left = t1, right = t2;
        int piv = arr[new Random().nextInt(right - left + 1) + left];
        while (left <= right) {
            while (arr[left] < piv)
                left++;
            while (arr[right] > piv)
                right--;
            if (left <= right)
                Helper.swap(arr, left++, right--);
        }
        if (t1 < right)
            qsort(arr, t1, right);
        if (t2 > left)
            qsort(arr, left, t2);

        return arr;
    }


}