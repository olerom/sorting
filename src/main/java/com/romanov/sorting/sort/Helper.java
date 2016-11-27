package com.romanov.sorting.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by olerom on 19.11.16.
 */
public class Helper {

    public static void main(String[] args) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BiggerData.txt"))) {

            for (int i = 0; i < 10000; i++) {
                bufferedWriter.write(new Random().nextInt(1000000) + " ");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] getArray() {
        int[] array = new int[10000];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("BiggerData.txt"))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < 10000; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return array;
    }

    public static int[] getArraySmall() {
        int[] array = new int[1000];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("SmallData.txt"))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < 1000; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return array;
    }

    public static int[] getSorted(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        return a;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static int[] genReverse(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = n - i;
        }
        return a;
    }

    public static int[] antiQuick(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        for (int i = 2; i < a.length; i++) {
            int tmp = a[i];
            a[i] = a[i >> 1];
            a[i >> 1] = tmp;
        }
        return a;
    }

    public static int binarySearch(int a[], int key, int right) {
        int left = -1;
        right++;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (a[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right == a.length)
            return right - 1;
        return right;
    }

    public static String[] genStrings(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = getRandLen(new Random().nextInt(60));
        }
        return a;
    }

    public static String[] getMSDBest(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = getRandLen(new Random().nextInt(60));
        }
        Arrays.sort(a);
        return a;
    }

    public static String getRandLen(int n) {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRTSUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = chars[new Random().nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
