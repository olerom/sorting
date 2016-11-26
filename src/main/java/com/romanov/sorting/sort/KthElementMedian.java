package com.romanov.sorting.sort;

/**
 * Created by olerom on 21.11.16.
 */
public class KthElementMedian {
    public static void main(String[] args) {
        int[] test = {1, 4, 5, 6, 3, 2};
        System.out.println(KthElementMedian.kthElement(test, 0, test.length - 1, 6));
    }

    public static int kthElement(int[] arr, int left, int right, int k) {
        if (k > 0 && k <= right - left + 1) {
            int n = right - left + 1;
            int i;
            int[] medians = new int[(n + 4) / 5];

            for (i = 0; i < n / 5; i++) {
                int m = left + 5 * i;
                medians[i] = median(arr, m, m + 5);
            }

            if (i * 5 < n) {
                int m = left + i * 5;
                medians[i] = median(arr, m, m + n % 5);
                i++;
            }

            int medOfMed = (i == 1) ? medians[i - 1] : kthElement(medians, 0, i - 1, i / 2);
            int pos = partition(arr, left, right, medOfMed);

            if (pos - left == k - 1) {
                return arr[pos];
            }
            if (pos - left > k - 1) {
                return kthElement(arr, left, pos - 1, k);
            }
            return kthElement(arr, pos + 1, right, k - pos + left - 1);
        }
        return Integer.MIN_VALUE;
    }

    private static int partition(int[] arr, int left, int right, int k) {
        int i;
        for (i = left; i < right; i++) {
            if (arr[i] == k) {
                break;
            }
        }
        Helper.swap(arr, i, right);

        i = left;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= k) {
                Helper.swap(arr, i, j);
                i++;
            }
        }

        Helper.swap(arr, i, right);
        return i;
    }

    private static int median(int[] arr, int left, int right) {
        sort(arr, left, right);
        return ((right + left) % 2 == 0) ? arr[(left + right - 1) / 2] : arr[(left + right) / 2];
//        return ((right >> 1 + left >> 1) == 1) ? arr[left >> 1 + right >> 1] : arr[left >> 1 + (right - 1) >> 1];
    }

    // Insertion? Possibly, enough
    private static void sort(int[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            int j;
            int curr = array[i];
            for (j = i; j > 0 && array[j - 1] > curr; j--) {
                array[j] = array[j - 1];
            }
            array[j] = curr;
        }
    }

}
