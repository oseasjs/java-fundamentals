package com.java.fundamentals.algoritms.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchAlgorithmsTest {

    private int[] values;

    @Before
    public void setup() {
        // sorted array
        this.values = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    public void testBinarySearchSuccessfully() {
        Assert.assertEquals(5, new BinarySearch().search(values, 7, 0, values.length -1));
    }

    @Test
    public void testBinarySearchRecursiveSuccessfully() {
        Assert.assertEquals(5, new BinarySearchRecursive().search(values, 7, 0, values.length -1));
    }

    @Test
    public void testLinearSearch() {
        Assert.assertEquals(5, new LinearSearch().search(values, 7));
    }

}
