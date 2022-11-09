package com.java.fundamentals.algoritms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchAlgorithmsTest {

    private final SearchAlgorithms search = new SearchAlgorithms();

    private int[] values;

    @Before
    public void setup() {
        // sorted array
        this.values = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    public void testBinarySearchSuccessfully() {
        Assert.assertEquals(5, search.binarySearch(values, 7, 0, values.length -1));
    }

    @Test
    public void testBinaryRecursiveSearchSuccessfully() {
        Assert.assertEquals(5, search.binaryRecursiveRecursive(values, 7, 0, values.length -1));
    }

    @Test
    public void testLinearSearch() {
        Assert.assertEquals(5, search.linearSearch(values, 7));
    }

}
