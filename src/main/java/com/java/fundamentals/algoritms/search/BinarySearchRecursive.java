package com.java.fundamentals.algoritms.search;

public class BinarySearchRecursive {

    public int search(int[] arr, int value, int low, int high) {
        if (high > low) {
            int mid = low + (high - low) /2;
            if (arr[mid] == value)
                return mid;
            if (arr[mid] > value)
                return search(arr, value, low, mid -1);
            else
                return search(arr, value, mid +1, high);
        }
        return -1;
    }

    /**
     * Binary Search Complexity Recursive
     *
     * Time Complexities
     *
     *     Best case complexity: O(1)
     *     Average case complexity: O(log n)
     *     Worst case complexity: O(log n)
     *
     * Space Complexity
     *
     * The space complexity of the binary search recursive is O(1).
     *
     * @param args
     */

    public static void main(String[] args) {

        int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9};

        BinarySearchRecursive bs = new BinarySearchRecursive();
        int result = bs.search(values, 7, 0, values.length -1);
        int expectedResult = 5;

        if (result != expectedResult)
            throw new RuntimeException(String.format("Invalid result. Expected %d, but found %d", expectedResult, result));

    }

}
