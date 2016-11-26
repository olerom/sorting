package com.romanov.sorting.sort;

import java.util.Random;

/**
 * Created by olerom on 20.11.16.
 */
//TODO QuickSortRandomThree FULL
public class QuickSortRandomThree {

    public static int[] qsort(int[] arr, int b, int e) {
        int l = b, r = e;
        int piv = arr[new Random().nextInt(r - l + 1) + l]; // Опорным элементом для примера возьмём средний
        while (l <= r) {
            while (arr[l] < piv)
                l++;
            while (arr[r] > piv)
                r--;
            if (l <= r)
                Helper.swap(arr, l++, r--);
        }
        if (b < r)
            qsort(arr, b, r);
        if (e > l)
            qsort(arr, l, e);

        return arr;
    }


}