package com.java.fundamentals.algoritms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortAlgorithmsTest {

    private final SortAlgorithms sort = new SortAlgorithms();

    private int[] values;
    private int[] expected;

    @Before
    public void setup() {
        this.values = new int[]{-3, 5, 7, 2, -9, 9};
        this.expected = new int[]{-9, -3, 2, 5, 7, 9};
    }

    @Test
    public void testBubbleSortSuccessfully() {
        sort.bubbleSort(values);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

    @Test
    public void testSelectionSortSuccessfully() {
        sort.selectionSort(values);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

    @Test
    public void testInsertionSortSuccessfully() {
        sort.insertionSort(values);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

}
