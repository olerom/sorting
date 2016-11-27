package com.romanov.sorting.sort;

/**
 * Created by olerom on 27.11.16.
 */

public class QuickSortBinary {
    public static int[] sort(int[] ar) {
        if (ar == null) {
            return new int[]{};
        }
        sort(ar, 0, ar.length - 1, 31);
        return ar;
    }

    static int digit(int n, int k) {
        return (n >> k) & 1;
    }

    public static int[] sort(int[] ar, int l, int r, int currDigit) {
        if (l < r && !(currDigit < 0)) {
            int index = partition(ar, l, r, currDigit);
            sort(ar, l, index, currDigit - 1);
            sort(ar, index + 1, r, currDigit - 1);
        }
        return ar;
    }

    public static int partition(int[] ar, int l, int r, int bit) {
        int i = l;
        int j = r;
        while (i <= j) {
            while (i < ar.length && digit(ar[i], bit) == 0) i++;
            while (j > -1 && digit(ar[j], bit) == 1) j--;
            if (i <= j) Helper.swap(ar, i++, j--);
        }
        return j;
    }

}