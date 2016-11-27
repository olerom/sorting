package com.romanov.sorting;

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.QuickSortRandomThree;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by olerom on 20.11.16.
 */
public class QuickSortRandomThreeTest {
    @Test
    public void maxAndMin() {
        int test[] = Helper.gen(1000);
        test[0] = Integer.MIN_VALUE;
        test[1] = Integer.MAX_VALUE;

        int tmp[] = new int[1000];

        System.arraycopy(test, 0, tmp, 0, test.length);

        QuickSortRandomThree.sort(test);
        Arrays.sort(tmp);

        assertTrue(Arrays.equals(test, tmp));
    }

    @Test
    public void maxPluseMinus() {
        int test[] = Helper.gen(1000);
        test[0] = Integer.MAX_VALUE + 1;
        test[1] = Integer.MAX_VALUE - 1;

        int tmp[] = new int[1000];

        System.arraycopy(test, 0, tmp, 0, test.length);

        QuickSortRandomThree.sort(test);
        Arrays.sort(tmp);

        assertTrue(Arrays.equals(test, tmp));
    }

    @Test
    public void minMinusPluse() {
        int test[] = Helper.gen(1000);
        test[0] = Integer.MIN_VALUE - 1;
        test[1] = Integer.MIN_VALUE + 1;

        int tmp[] = new int[1000];

        System.arraycopy(test, 0, tmp, 0, test.length);

        QuickSortRandomThree.sort(test);
        Arrays.sort(tmp);

        assertTrue(Arrays.equals(test, tmp));
    }

    @Test
    public void duplicate() {
        int test[] = Helper.gen(1000);
        test[0] = 100;
        test[1] = 100;
        test[110] = 100;
        test[111] = 100;

        int tmp[] = new int[1000];

        System.arraycopy(test, 0, tmp, 0, test.length);

        QuickSortRandomThree.sort(test);
        Arrays.sort(tmp);

        assertTrue(Arrays.equals(test, tmp));
    }

    @Test
    public void oddNumber() {
        int test[] = Helper.gen(10000);
        int tmp[] = new int[10000];

        System.arraycopy(test, 0, tmp, 0, test.length);

        QuickSortRandomThree.sort(test);
        Arrays.sort(tmp);

        assertTrue(Arrays.equals(test, tmp));
    }

    @Test
    public void evenNumber() {
        int test[] = Helper.gen(10001);

        int tmp[] = new int[10001];

        System.arraycopy(test, 0, tmp, 0, test.length);

        QuickSortRandomThree.sort(test);
        Arrays.sort(tmp);

        assertTrue(Arrays.equals(test, tmp));
    }

    @Test
    public void oneElement() {
        int[] test = {8};
        int[] result = QuickSortRandomThree.sort(test);
        int[] compare = {8};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void empty() {
        int[] test = {};
        int[] result = QuickSortRandomThree.sort(test);
        int[] compare = {};

        assertTrue(Arrays.equals(compare, result));
    }
}
