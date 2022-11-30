package com.java.fundamentals.algoritms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortAlgorithmsTest {

    private int[] values;
    private int[] expected;

    @Before
    public void setup() {
        this.values = new int[]{-3, 5, 7, 2, -9, 9};
        this.expected = new int[]{-9, -3, 2, 5, 7, 9};
    }

    @Test
    public void testBubbleSortSuccessfully() {
        new BubbleSort().sort(values);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

    @Test
    public void testSelectionSortSuccessfully() {
        new SelectionSort().sort(values);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

    @Test
    public void testInsertionSortSuccessfully() {
        new InsertionSort().sort(values);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

}
