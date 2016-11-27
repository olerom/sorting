package com.romanov.sorting.sort;

/**
 * Created by olerom on 27.11.16.
 */
public class MSDStrings {
    private static int R = 256;        // Количество символов
    private static final int M = 15;   // подмассивы
    private static String[] aux;       // вспомогательный массив

    private static int charAt(String s, int d) { // символ у позиции
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static String[] sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
        return a;
    }

    private static void sort(String[] a, int lo, int hi, int d) {  // сортируем от a[lo] до a[hi], начиная с d-ого символа
        if (hi <= lo + M) {
            insertionSort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2];        // считаем частоту
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        for (int i = lo; i <= hi; i++)     // обратно копируем
            a[i] = aux[i - lo];
        // рекурсивно по чару далее
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }

    public static void insertionSort(String[] a, int lo, int hi, int d) {  // сорт с a[lo] до a[hi], с dого символа
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                swap(a, j, j - 1);
    }

    public static void swap(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }
}