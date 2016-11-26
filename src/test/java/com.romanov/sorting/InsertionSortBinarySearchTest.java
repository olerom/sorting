package com.romanov.sorting;

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.InsertionSortBinarySearch;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by olerom on 19.11.16.
 */
public class InsertionSortBinarySearchTest {
    @Test
    public void maxAndMin() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] result = InsertionSortBinarySearch.sort(test);
        int[] compare = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void maxPluseMinus() {
        int[] test = {Integer.MAX_VALUE + 1, Integer.MAX_VALUE - 1};
        int[] result = InsertionSortBinarySearch.sort(test);
        int[] compare = {Integer.MAX_VALUE + 1, Integer.MAX_VALUE - 1};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void minMinusPluse() {
        int[] test = {Integer.MIN_VALUE - 1, Integer.MIN_VALUE + 1};
        int[] result = InsertionSortBinarySearch.sort(test);
        int[] compare = {Integer.MIN_VALUE + 1, Integer.MIN_VALUE - 1};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void duplicate() {
        int[] test = {5, 5, 5, 4, 3, 2, 2, 3};
        int[] result = InsertionSortBinarySearch.sort(test);
        int[] compare = {2, 2, 3, 3, 4, 5, 5, 5};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void oddNumber() {
        int[] test = Helper.gen(1000);
        int[] result = test;
        Arrays.sort(test);
        InsertionSortBinarySearch.sort(test);

        assertTrue(Arrays.equals(result, test));
    }

    @Test
    public void evenNumber() {
        int[] test = Helper.gen(1001);
        int[] result = test;
        Arrays.sort(result);
        InsertionSortBinarySearch.sort(test);

        assertTrue(Arrays.equals(result, test));
    }

    @Test
    public void oneElement() {
        int[] test = {8};
        int[] result = InsertionSortBinarySearch.sort(test);
        int[] compare = {8};

        assertTrue(Arrays.equals(compare, result));
    }

    @Test
    public void empty() {
        int[] test = {};
        int[] result = InsertionSortBinarySearch.sort(test);
        int[] compare = {};

        assertTrue(Arrays.equals(compare, result));
    }
}
