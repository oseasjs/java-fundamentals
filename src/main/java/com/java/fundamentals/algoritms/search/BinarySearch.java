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

    /**
     * Binary Search Complexity
     *
     * Time Complexities
     *     Best case complexity: O(1)
     *     Average case complexity: O(log n)
     *     Worst case complexity: O(log n)
     *
     * Space Complexity
     *
     * The space complexity of the binary search is O(1).
     * @param args
     */
    public static void main(String[] args) {

        int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9};

        BinarySearch bs = new BinarySearch();
        int result = bs.search(values, 7, 0, values.length -1);
        int expectedResult = 5;

        if (result != expectedResult)
            throw new RuntimeException(String.format("Invalid result. Expected %d, but found %d", expectedResult, result));

    }

}
