package com.romanov.sorting;

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.KthElement;
import com.romanov.sorting.sort.KthElementMedian;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olerom on 21.11.16.
 */

// Для обычной и улучшенной
public class KthElementTest {
    @Test
    public void mainTest() {
        int test[] = Helper.gen(10000);

        for (int i = 0; i < test.length; i++) {
            assertEquals(i, KthElement.kthElement(test, i));
            assertEquals(i, KthElementMedian.kthElement(test, i + 1));
        }
    }

}
