package com.java.fundamentals.algoritms.sort;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size -1; i++) {
            for (int j = 0; j < size -i -1; j++) {
                if (arr[j] > arr[j +1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j +1] = tmp;
                }
            }
        }
    }

    /**
     * 1. Time Complexities
     *
     *     Worst Case Complexity: O(n2)
     *     If we want to sort in ascending order and the array is in descending order then the worst case occurs.
     *     Best Case Complexity: O(n)
     *     If the array is already sorted, then there is no need for sorting.
     *     Average Case Complexity: O(n2)
     *     It occurs when the elements of the array are in jumbled order (neither ascending nor descending).
     *
     * 2. Space Complexity
     *
     *     Space complexity is O(1) because an extra variable is used for swapping.
     *     In the optimized bubble sort algorithm, two extra variables are used. Hence, the space complexity will be O(2).
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] values = new int[]{-3, 5, 7, 2, -9, 9};
        new BubbleSort().sort(values);
        int[] expected = new int[]{-9, -3, 2, 5, 7, 9};

        if (!Arrays.toString(values).equals(Arrays.toString(expected)))
            throw new RuntimeException(String.format("Invalid result. Expected %s, but found %s",
                Arrays.toString(expected), Arrays.toString(values)));
    }

}
