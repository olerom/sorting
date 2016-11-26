package com.romanov.sorting;

import com.romanov.sorting.sort.KthElement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olerom on 21.11.16.
 */
public class KthElementTest {
    @Test
    public void maxAndMin() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        assertEquals(Integer.MAX_VALUE, KthElement.kthElement(test, 1));
        assertEquals(Integer.MIN_VALUE, KthElement.kthElement(test, 0));
    }


    @Test
    public void oddNumber() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE, 9, 0, 9, 2, 4, 3, 6};

        assertEquals(Integer.MAX_VALUE, KthElement.kthElement(test, 8));
        assertEquals(Integer.MIN_VALUE, KthElement.kthElement(test, 0));
        assertEquals(0, KthElement.kthElement(test, 1));
        assertEquals(2, KthElement.kthElement(test, 2));
    }

    @Test
    public void evenNumber() {
        int[] test = {Integer.MAX_VALUE, Integer.MIN_VALUE, 9, 0, 9, 2, 4, 3, 6, 606};

        assertEquals(Integer.MAX_VALUE, KthElement.kthElement(test, 9));
        assertEquals(Integer.MIN_VALUE, KthElement.kthElement(test, 0));
        assertEquals(0, KthElement.kthElement(test, 1));
        assertEquals(2, KthElement.kthElement(test, 2));
        assertEquals(606, KthElement.kthElement(test, 8));
    }
}
