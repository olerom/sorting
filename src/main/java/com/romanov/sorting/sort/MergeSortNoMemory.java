package com.romanov.sorting.sort;

/**
 * Created by olerom on 20.11.16.
 */
//TODO MergeSortNoMemory only, width odd test crash
public class MergeSortNoMemory {
    // сляние двух групп елементов одинокового размера
    public static int[] mergegroup(int a[], int n, int st1, int st2, int st3) {
        a = swapgroup(a, n, st1, st3);
        int take1 = 0;
        int take2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if ((take2 == n) || ((take1 < n) && (a[take1 + st3] < a[take2 + st2]))) {
                int t = a[st1 + i];
                a[st1 + i] = a[take1 + st3];
                a[take1 + st3] = t;
                take1++;
            } else {
                int t = a[st1 + i];
                a[st1 + i] = a[take2 + st2];
                a[take2 + st2] = t;
                take2++;
            }
        }
        return a;
    }


    // сортировка выбором
    public static int[] slowsort(int a[], int st, int en) {
        for (int i = st; i < en; i++) {
            for (int j = i + 1; j < en; j++) {
                if (a[i] > a[j]) {
                    int k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
            }
        }
        return a;
    }


    // обмен местами двух групп елементов одинакового размера
    public static int[] swapgroup(int a[], int n, int st1, int st2) {
        for (int i = 0; i < n; i++) {
            int k = a[st1 + i];
            a[st1 + i] = a[st2 + i];
            a[st2 + i] = k;
        }
        return a;
    }


    //слияние
    public static int[] merge(int[] a, int n) {
        if (n <= 16) {
            a = slowsort(a, 0, n);
            return a;
        }

        // разрез на группы длиной корень из n
        int sizegroup = (int) Math.sqrt(n);
        int remainder = n % sizegroup;
        int numofgrp = n / sizegroup - 1;

        // поиск конца первого массива
        int posgap = 0;
        while ((posgap < sizegroup * numofgrp) && (a[posgap] <= a[posgap + 1]))
            posgap++;

        // обмен группы содержащей конец первого массива  с последней и обьединение с остатком
        a = swapgroup(a, sizegroup, numofgrp * sizegroup, posgap - posgap
                % sizegroup);
        remainder += sizegroup;

        // сортировка групп по первому елементу(в случае равенства по последнему)
        for (int i = 0; i < numofgrp - 1; i++) {
            int minnum = i;
            for (int j = i + 1; j < numofgrp; j++)
                if ((a[j * sizegroup] < a[minnum * sizegroup])
                        || ((a[j * sizegroup] == a[minnum * sizegroup])
                        && (a[(j + 1) * sizegroup - 1] < a[(minnum + 1) * sizegroup - 1])))
                    minnum = j;
            a = swapgroup(a, sizegroup, i * sizegroup, minnum * sizegroup);
        }

        // поочередное слияние групп
        for (int i = 0; i < numofgrp - 1; i++) {
            a = mergegroup(a, sizegroup, i * sizegroup, (i + 1) * sizegroup,
                    numofgrp * sizegroup);
        }

        // сортировка конца массива
        a = slowsort(a, n - 2 * remainder, n);

        // поочередное слияние групп в обратную сторону
        for (int i = n - 2 * remainder; i >= remainder; i -= remainder)
            a = mergegroup(a, remainder, i - remainder, i, n - remainder);

        // сортировка начала и конца массива
        a = slowsort(a, 0, 2 * remainder);
        a = slowsort(a, n - remainder, n);
        return a;
    }

    public static int[] sort(int[] a) {
        for (int i = 1; i <= a.length; i *= 2) {
            for (int j = 0; j < a.length; j += i) {
                int size = Math.min(a.length, j + i) - j;
                swapgroup(a, size, 0, j);      // для удобства реализации перемещаем
                merge(a, size);                // требуемый кусок масcива в начало
                swapgroup(a, size, 0, j);      // там его сортируем и возвращаем обратно
            }
        }
        if (a.length > 16) {
            merge(a, a.length);
        }
        return a;
    }
}
