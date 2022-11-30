package com.java.fundamentals.algoritms.search;

public class BinarySearch {

    public int search(int[] arr, int value, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value)
                return mid;
            if (arr[mid] < value)
                low = mid +1;
            else
                high = mid -1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9};

        BinarySearch bs = new BinarySearch();
        int result = bs.search(values, 7, 0, values.length -1);
        int expectedResult = 5;

        if (result != expectedResult)
            throw new RuntimeException(String.format("Invalid result. Expected %d, but found %d", expectedResult, result));

    }

}
