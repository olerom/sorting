package com.romanov.sorting;

import com.romanov.sorting.sort.KthElementMedian;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olerom on 21.11.16.
 */
public class KthElementMedianTest {
    @Test
    public void maxAndMin() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        assertEquals(Integer.MAX_VALUE, KthElementMedian.kthElement(test, 0, test.length - 1, 2));
        assertEquals(Integer.MIN_VALUE, KthElementMedian.kthElement(test, 0, test.length - 1, 1));
    }


    @Test
    public void oddNumber() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE, 9, 0, 9, 2, 4, 3, 6};

        assertEquals(Integer.MAX_VALUE, KthElementMedian.kthElement(test, 0, test.length - 1, 9));
        assertEquals(Integer.MIN_VALUE, KthElementMedian.kthElement(test, 0, test.length - 1, 1));
        assertEquals(0, KthElementMedian.kthElement(test, 0, test.length - 1, 2));
        assertEquals(2, KthElementMedian.kthElement(test, 0, test.length - 1, 3));
    }

    @Test
    public void evenNumber() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE, 9, 0, 9, 2, 4, 3, 6, 606};

        assertEquals(Integer.MAX_VALUE, KthElementMedian.kthElement(test, 0, test.length - 1, 10));
        assertEquals(Integer.MIN_VALUE, KthElementMedian.kthElement(test, 0, test.length - 1, 11));
        assertEquals(0, KthElementMedian.kthElement(test, 0, test.length - 1, 2));
        assertEquals(2, KthElementMedian.kthElement(test, 0, test.length - 1, 3));
        assertEquals(606, KthElementMedian.kthElement(test, 0, test.length - 1, 9));
    }
}

