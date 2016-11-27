package com.romanov.sorting;

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.MSDStrings;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by olerom on 27.11.16.
 */
public class MSDStringsTest {
    @Test
    public void mainTest() {
        String[] test = Helper.genStrings(1000);
        String[] tmp = new String[1000];

        System.arraycopy(test, 0, tmp, 0, test.length);
        MSDStrings.sort(test);
        Arrays.sort(tmp);

        assertTrue(Arrays.equals(test, tmp));
    }
}
