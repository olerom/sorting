package com.romanov.sorting;

import com.romanov.sorting.sort.MergeSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by olerom on 20.11.16.
 */
public class MergeSortTest {
    @Test
    public void maxAndMin() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] result = MergeSort.sort(test);
        int[] compare = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void maxPluseMinus() {
        int[] test = {Integer.MAX_VALUE + 1, Integer.MAX_VALUE - 1};
        int[] result = MergeSort.sort(test);
        int[] compare = {Integer.MAX_VALUE + 1, Integer.MAX_VALUE - 1};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void minMinusPluse() {
        int[] test = {Integer.MIN_VALUE - 1, Integer.MIN_VALUE + 1};
        int[] result = MergeSort.sort(test);
        int[] compare = {Integer.MIN_VALUE + 1, Integer.MIN_VALUE - 1};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void duplicate() {
        int[] test = {5, 5, 5, 4, 3, 2, 2, 3};
        int[] result = MergeSort.sort(test);
        int[] compare = {2, 2, 3, 3, 4, 5, 5, 5};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void oddNumber() {
        int[] test = {8, 6, 5, 1, 5, 3, 7};
        int[] result = MergeSort.sort(test);
        int[] compare = {1, 3, 5, 5, 6, 7, 8};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void evenNumber() {
        int[] test = {8, 6, 5, 1, 5, 3, 7, -6};
        int[] result = MergeSort.sort(test);
        int[] compare = {-6, 1, 3, 5, 5, 6, 7, 8};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void oneElement() {
        int[] test = {8};
        int[] result = MergeSort.sort(test);
        int[] compare = {8};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void empty() {
        int[] test = {};
        int[] result = MergeSort.sort(test);
        int[] compare = {};

        assertTrue(Arrays.equals(compare, result));
    }
}
