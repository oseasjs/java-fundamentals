package com.java.fundamentals.algoritms.search;

public class LinearSearch {

    public int search(int[] arr, int value) {
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9};

        LinearSearch ls = new LinearSearch();
        int result = ls.search(values, 7);
        int expectedResult = 5;

        if (result != expectedResult)
            throw new RuntimeException(String.format("Invalid result. Expected %d, but found %d", expectedResult, result));

    }

}
